package com.arkenna.indienest.backend.payment.interfaces.rest;


import com.arkenna.indienest.backend.payment.domain.model.queries.GetAllShoppingCartsQuery;
import com.arkenna.indienest.backend.payment.domain.model.queries.GetShoppingCartByIdQuery;
import com.arkenna.indienest.backend.payment.domain.services.ShoppingCartCommandService;
import com.arkenna.indienest.backend.payment.domain.services.ShoppingCartQueryService;
import com.arkenna.indienest.backend.payment.interfaces.rest.resources.AddGameToShoppingCartResource;
import com.arkenna.indienest.backend.payment.interfaces.rest.resources.CreateShoppingCartResource;
import com.arkenna.indienest.backend.payment.interfaces.rest.resources.DeleteGameFromShoppingCartResource;
import com.arkenna.indienest.backend.payment.interfaces.rest.resources.ShoppingCartResource;
import com.arkenna.indienest.backend.payment.interfaces.rest.transform.AddGameToShoppingCartCommandFromResourceAssembler;
import com.arkenna.indienest.backend.payment.interfaces.rest.transform.CreateShoppingCartCommandFromResourceAssembler;
import com.arkenna.indienest.backend.payment.interfaces.rest.transform.DeleteGameFromShoppingCartCommandFromResourceAssembler;
import com.arkenna.indienest.backend.payment.interfaces.rest.transform.ShoppingCartResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/shopping-carts", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "ShoppingCarts", description = "Available ShoppingCart Endpoints")
public class ShoppingCartsController {

    private final ShoppingCartCommandService  shoppingCartCommandService;
    private final ShoppingCartQueryService shoppingCartQueryService;

    /**
     * Constructor
     *
     * @param shoppingCartCommandService The {@link ShoppingCartCommandService} instance
     * @param shoppingCartQueryService The {@link ShoppingCartQueryService} instance
     */
    public ShoppingCartsController(ShoppingCartCommandService shoppingCartCommandService, ShoppingCartQueryService shoppingCartQueryService) {
        this.shoppingCartCommandService = shoppingCartCommandService;
        this.shoppingCartQueryService = shoppingCartQueryService;
    }

    /**
     * Create a new ShoppingCart
     * @param resource The {@link CreateShoppingCartResource} instance
     * @return A {@link ShoppingCartResource} resource for the created ShoppingCart, or a bad request response if the ShoppingCart could not be created.
     */
    @PostMapping
    @Operation(summary = "Create a new ShoppingCart")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "ShoppingCart created"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    public ResponseEntity<ShoppingCartResource> createShoppingCart(@RequestBody CreateShoppingCartResource resource){

        var createShoppingCartCommand = CreateShoppingCartCommandFromResourceAssembler.toCommandFromResource(resource);
        var shoppingCart = shoppingCartCommandService.handle(createShoppingCartCommand);
        if(shoppingCart.isEmpty()) return ResponseEntity.badRequest().build();
        var createdShoppingCart = shoppingCart.get();
        var shoppingCartResource = ShoppingCartResourceFromEntityAssembler.toResourceFromEntity(createdShoppingCart);
        return new  ResponseEntity<>(shoppingCartResource, HttpStatus.CREATED);
    }

    /**
     * Get an ShoppingCart by ID
     * @param shoppingCartId The ShoppingCart ID
     * @return A {@link ShoppingCartResource} resource for the ShoppingCart, or a not found response if the ShoppingCart could not be found.
     */
    @GetMapping("/{shoppingCartId}")
    @Operation(summary = "Get a ShoppingCart by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ShoppingCart found"),
            @ApiResponse(responseCode = "404", description = "ShoppingCart not found")})
    public ResponseEntity<ShoppingCartResource> getShoppingCartById(@PathVariable Integer shoppingCartId) {
        var getShoppingCartByIdQuery = new GetShoppingCartByIdQuery(shoppingCartId);
        var shoppingCart = shoppingCartQueryService.handle(getShoppingCartByIdQuery);
        if (shoppingCart.isEmpty()) return ResponseEntity.notFound().build();
        var ShoppingCartEntity = shoppingCart.get();
        var shoppingCartResource = ShoppingCartResourceFromEntityAssembler.toResourceFromEntity(ShoppingCartEntity);
        return ResponseEntity.ok(shoppingCartResource);
    }

    /**
     * Get all ShoppingCarts
     * @return A list of {@link ShoppingCartResource} resources for all ShoppingCarts, or a not found response if no ShoppingCarts are found.
     */
    @GetMapping
    @Operation(summary = "Get all ShoppingCarts")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ShoppingCarts found"),
            @ApiResponse(responseCode = "404", description = "ShoppingCarts not found")})
    public ResponseEntity<List<ShoppingCartResource>> getAllShoppingCarts() {
        var shoppingCarts = shoppingCartQueryService.handle(new GetAllShoppingCartsQuery());
        if (shoppingCarts.isEmpty()) return ResponseEntity.notFound().build();
        var shoppingCartResources = shoppingCarts.stream()
                .map(ShoppingCartResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(shoppingCartResources);
    }


    @PutMapping("/add-game")
    @Operation(summary = "Add a game to a ShoppingCart")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ShoppingCart updated"),
            @ApiResponse(responseCode = "400", description = "Bad Request")})
    public ResponseEntity<ShoppingCartResource> addGameToCart(@RequestBody AddGameToShoppingCartResource resource) {

        var command = AddGameToShoppingCartCommandFromResourceAssembler.toCommandFromResource(resource);
        var shoppingCart = shoppingCartCommandService.handle(command);
        if(shoppingCart.isEmpty()) return ResponseEntity.badRequest().build();
        var createdShoppingCart = shoppingCart.get();
        var cartResource = ShoppingCartResourceFromEntityAssembler.toResourceFromEntity(createdShoppingCart);

        return ResponseEntity.ok(cartResource);
    }


    @PutMapping("/delete-game")
    @Operation(summary = "Remove a game to a ShoppingCart")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ShoppingCart updated"),
            @ApiResponse(responseCode = "400", description = "Bad Request")})
    public ResponseEntity<ShoppingCartResource> removeGameFromCart(@RequestBody DeleteGameFromShoppingCartResource resource) {

        var command = DeleteGameFromShoppingCartCommandFromResourceAssembler.toCommandFromResource(resource);
        var shoppingCart = shoppingCartCommandService.handle(command);
        if(shoppingCart.isEmpty()) return ResponseEntity.badRequest().build();
        var createdShoppingCart = shoppingCart.get();
        var cartResource = ShoppingCartResourceFromEntityAssembler.toResourceFromEntity(createdShoppingCart);

        return ResponseEntity.ok(cartResource);
    }
}
