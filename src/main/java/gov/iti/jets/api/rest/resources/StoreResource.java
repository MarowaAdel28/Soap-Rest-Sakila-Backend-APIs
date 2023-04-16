package gov.iti.jets.api.rest.resources;

import gov.iti.jets.dto.*;
import gov.iti.jets.service.InventoryService;
import gov.iti.jets.service.StoreService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

import java.util.List;

@Path("stores")
public class StoreResource {

    private StoreService storeService;

    private InventoryService inventoryService;
    public StoreResource() {
        storeService = StoreService.getInstance();
        inventoryService = InventoryService.getInstance();
    }

    @GET
    public List<StoreDto> getAll() {
        return storeService.getAllStores();
    }

    @GET
    @Path("{id:[0-9]+}")
    public StoreDto getById(@PathParam("id") Short id) {
        return storeService.getStoreById(id);
    }

    @GET
    @Path("{id:[0-9]+}/customers")
    public List<CustomerInfoDto> getStoreCustomerList(@PathParam("id") Short id) {
        return storeService.getStoreCustomerList(id);
    }

    @GET
    @Path("{id:[0-9]+}/staffs")
    public List<StaffDto> getStoreStaffList(@PathParam("id") Short id) {
        return storeService.getStoreStaffList(id);
    }

    @GET
    @Path("{id:[0-9]+}/inventries")
    public List<InventoryDto> getStoreInventoryList(@PathParam("id") Short storeId) {
        return storeService.getStoreInventoryList(storeId);
    }

    @GET
    @Path("{id:[0-9]+}/films")
    public List<FilmDto> getStoreFilms(@PathParam("id") Short storeId) {
        return inventoryService.getStoreFilms(storeId);
    }
}
