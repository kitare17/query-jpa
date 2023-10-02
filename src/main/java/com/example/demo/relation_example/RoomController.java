package com.example.demo.relation_example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RoomController {
    @Autowired
    private RoomRespository roomRespository;
    @GetMapping("/room")
    public List<Room> getAllRoom(){
        List<Room> roomArrayList=roomRespository.findAll();
        return roomArrayList;
    }
    @PostMapping("/room")
    private Room addNewRoom(@RequestBody Room room){
        room.setRoomId(0);
      return   roomRespository.save(room);
    }
    @PutMapping("/room/{id}")
    private Room updateRoom(@PathVariable int id,@RequestBody Room roomNew){
        Optional<Room> roomOld=roomRespository.findById(id);
        if(roomOld.isEmpty()){
         throw  new RuntimeException("Id này không tồn tại");
        }
        roomNew.setRoomId(id);
        return roomRespository.save(roomNew);
    }

}
