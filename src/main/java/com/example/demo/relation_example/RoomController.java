package com.example.demo.relation_example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RoomController {

    @Autowired
    private RoomRespository roomRespository;
    @Autowired
    private UserRespository userRespository;
    @GetMapping("/room")
    public List<Room> getAllRoom(){
        List<Room> roomArrayList=roomRespository.findAll();
        for (Room room : roomArrayList
        ){
            try{
                System.out.println(room.getUser().getUserName());
//           room.getUser().

            }catch (Exception e){
                e.printStackTrace();
            }
        }
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
    @PutMapping("/room/{roomId}/user/{userId}")
    public User getUser(@PathVariable int userId,@PathVariable int roomId){
        Room room=roomRespository.findById(roomId).get();
        User user=userRespository.findById(userId).get();
        user.setRoom(room);
       return userRespository.save(user);
    }
}
