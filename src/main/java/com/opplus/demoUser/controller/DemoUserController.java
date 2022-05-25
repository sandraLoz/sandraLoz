package com.opplus.demoUser.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.opplus.demoUser.dto.UserDto;
import com.opplus.demoUser.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "DemoUser API")

@RestController
@RequestMapping("/User")
public class DemoUserController {
	
	private Logger logger = LoggerFactory.getLogger(DemoUserController.class);


	@Autowired
	private UserService userService;

	@PostMapping("/")
	@ApiOperation(value = "Create User", nickname = "Create User", response = UserDto.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = String.class),
			@ApiResponse(code = 201, message = "Created"), @ApiResponse(code = 400, message = "Bad request"),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userCreate) {
		try {
			return new ResponseEntity<UserDto>(this.userService.createUser(userCreate), HttpStatus.CREATED);
		} catch (ResponseStatusException e) {
			throw e;
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Delete User", nickname = "Delete User", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = String.class),
			@ApiResponse(code = 201, message = "Created"), @ApiResponse(code = 400, message = "Bad request"),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	public ResponseEntity<String> deleteUserById(@PathVariable(required = true, name = "id") Long userId) {
		try {
			if (this.userService.deleteUserById(userId) > 0)
				return new ResponseEntity<>("Deleted User by userId " + userId, HttpStatus.OK);
			else
				return new ResponseEntity<>("User Delete Error", HttpStatus.BAD_REQUEST);

		} catch (ResponseStatusException e) {
			logger.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@GetMapping("/")
	@ApiOperation(value = "Find all Users", nickname = "Find all Users", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = String.class),
			@ApiResponse(code = 201, message = "Created"), @ApiResponse(code = 400, message = "Bad request"),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	public ResponseEntity<List<UserDto>> findAll() {
		try {
			return ResponseEntity.ok(this.userService.findAll());

		} catch (Exception e) {
			logger.error(e.getMessage());
			return ResponseEntity.internalServerError().build();
		}

	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Find User By id", nickname = "Find User By id", response = UserDto.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = String.class),
			@ApiResponse(code = 201, message = "Created"), @ApiResponse(code = 400, message = "Bad request"),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	public ResponseEntity<UserDto> findUserById(@PathVariable(required = true, name = "id") Long id)
			throws ResponseStatusException {

		return ResponseEntity.ok(this.userService.findUserById(id));

	}

	@PutMapping("/{id}")
	@ApiOperation(value = "User Update", nickname = "User Update", response = UserDto.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = String.class),
			@ApiResponse(code = 201, message = "Created"), @ApiResponse(code = 400, message = "Bad request"),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	public ResponseEntity<UserDto> updateUserById(@RequestBody UserDto userUpd,
			@PathVariable(required = true, name = "id") Long id) {

		return ResponseEntity.ok(this.userService.updateUserById(id, userUpd));

	}
}
