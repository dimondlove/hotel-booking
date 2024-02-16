package ru.rudnev.hotelbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rudnev.hotelbooking.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
