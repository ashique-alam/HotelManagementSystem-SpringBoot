package com.ashique.guest.repository;



import org.springframework.data.mongodb.repository.MongoRepository;

import com.ashique.guest.entity.Guest;

public interface GuestRepository extends MongoRepository<Guest, String>{

}
