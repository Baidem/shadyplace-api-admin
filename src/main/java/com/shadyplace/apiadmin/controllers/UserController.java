package com.shadyplace.apiadmin.controllers;

import com.shadyplace.apiadmin.models.User;
import com.shadyplace.apiadmin.services.CommandService;
import com.shadyplace.apiadmin.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin // debug angular
@RequestMapping("/api/users")
@RestController()
@Tag(name = "User management", description = "Enables user CRUD")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    CommandService commandService;

    @GetMapping(value = "/", produces = "application/json") // renseigne le Media type : il produit du json
    @Operation(summary = "Recover all users") // renseigne sur la fonction de la requête
    @ApiResponses(
            @ApiResponse(description = "User list", responseCode = "200") // donne la description de la réponse et son code
    )
    public List<User> getAll() {
        return this.userService.findAll();
    }

    @GetMapping(value = "/{user}", produces = "application/json")
    @Operation(summary = "Recover a user based on his Id") // renseigne sur la fonction de la requête
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "User not found", content = {}), // réponse à NOT_FOUND
            @ApiResponse(responseCode = "200", description = "User found") // réponse à OK
    })
    public ResponseEntity<User> getOne(@PathVariable(name = "user", required = false) @Parameter(example = "1", description = "Id de l'utilisateur") User user) {
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"); // réponse 404
        }
        return new ResponseEntity<User>(user, HttpStatus.OK); // réponse 200
    }

    @PostMapping(value = "/", consumes = {"application/json"}, produces = {"application/json"}) // renseigne le Media type : il consomme et produit du json
    @Operation(summary = "Save new user") // renseigne sur la fonction de la requête
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "A user with this email already exists"), // réponse à BAD_REQUEST TODO content
            @ApiResponse(responseCode = "201", description = "The new user has been created") // réponse à CREATED
    })
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            required = true,
            content = @Content(examples = {
                    @ExampleObject(
                            name = "User",
                            summary = "User without Id and controls",
                            value = "{\n" +
                                    "    \"email\": \"example@gmail.com\",\n" +
                                    "    \"password\": \"example\",\n" +
                                    "    \"firstname\": \"example\",\n" +
                                    "    \"lastname\": \"example\",\n" +
                                    "    \"confirmPassword\": \"example\",\n" +
                                    "    \"residenceCountry\": \"FRANCE\",\n" +
                                    "    \"familyLink\": {\n" +
                                    "        \"id\": 7\n" +
                                    "    },\n" +
                                    "    \"currentFidelityRank\": {\n" +
                                    "        \"id\": 1\n" +
                                    "    },\n" +
                                    "    \"roles\": [\n" +
                                    "        {\n" +
                                    "            \"id\": 2\n" +
                                    "        }\n" +
                                    "    ]\n" +
                                    "}"
                    )
            })
    )
    public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {

        User existUser = this.userService.findByEmail(user.getEmail());

        if (existUser != null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "A user with this email already exists"
            ); // réponse 400
        }
        user = this.userService.saveNewUser(user);
        return new ResponseEntity<User>(user, HttpStatus.CREATED); // réponse 201
    }

    @PutMapping(value = "/{user}", consumes = {"application/json"}, produces = {"application/json"})
    @Operation(summary = "Update user data") // renseigne sur la fonction de la requête
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "This user does not exist", content ={}), // réponse à BAD_REQUEST
            @ApiResponse(responseCode = "400", description = "Another user has this email", content = {}), // réponse à BAD_REQUEST
            @ApiResponse(responseCode = "200", description = "The user has been updated") // réponse à CREATED
    })
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            required = true,
            content = @Content(examples = {
                    @ExampleObject(
                            name = "User",
                            summary = "User without Id and controls",
                            value = "{\n" +
                                    "    \"email\": \"example@gmail.com\",\n" +
                                    "    \"password\": \"example\",\n" +
                                    "    \"firstname\": \"example\",\n" +
                                    "    \"lastname\": \"example\",\n" +
                                    "    \"confirmPassword\": \"example\",\n" +
                                    "    \"residenceCountry\": \"FRANCE\",\n" +
                                    "    \"familyLink\": {\n" +
                                    "        \"id\": 7\n" +
                                    "    },\n" +
                                    "    \"currentFidelityRank\": {\n" +
                                    "        \"id\": 1\n" +
                                    "    },\n" +
                                    "    \"roles\": [\n" +
                                    "        {\n" +
                                    "            \"id\": 2\n" +
                                    "        }\n" +
                                    "    ]\n" +
                                    "}"
                    )
            })
    )
    public ResponseEntity<User> update(
            @PathVariable(name = "user", required = false)
            @Parameter(example = "1", description = "User id") User user,
            @Valid @RequestBody @Parameter User userUpdate

    ){
        if (user == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This user does not exist"); // réponse 404
        }

        List<User> userWithEmail = this.userService.findByEmailAndNotId(userUpdate.getEmail(), user.getId());

        if (!userWithEmail.isEmpty()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Another user has this email"
            ); // réponse 400
        }
        userUpdate.setId(user.getId());
        userUpdate.setRegistrationDate(user.getRegistrationDate());

        userUpdate = this.userService.updateUser(userUpdate);
        return new ResponseEntity<User>(userUpdate, HttpStatus.OK); // réponse 200 OK
    }


    @DeleteMapping(value = "/{user}", produces = "application/json")
    @Operation(summary = "Deletes user from database") // renseigne sur la fonction de la requête
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Impossible to delete this user, he has commands"), // réponse à BAD_REQUEST
            @ApiResponse(responseCode = "200", description = "The user has been deleted") // réponse à OK
    })
    public void deleteOne(@PathVariable(name = "user", required = false) @Parameter(example = "1", description = "User id") User user) {
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"); // réponse 404
        } else {
            if (!this.commandService.getCommandByUser(user).isEmpty()){
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Impossible to delete this user, he has commands"
                ); //réponse 400
            }
        }
        this.userService.delete(user);
    }

}
