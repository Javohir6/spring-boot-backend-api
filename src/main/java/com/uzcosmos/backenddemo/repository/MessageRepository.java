package com.uzcosmos.backenddemo.repository;

import com.uzcosmos.backenddemo.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    
}
