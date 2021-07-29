package com.ashique.roomservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ashique.roomservice.entity.Room;

public interface RoomRepository extends MongoRepository<Room, String>{


}
