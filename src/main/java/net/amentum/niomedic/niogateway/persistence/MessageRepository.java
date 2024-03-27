package net.amentum.niomedic.niogateway.persistence;

import net.amentum.niomedic.niogateway.model.MessageQueue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<MessageQueue, Long>, JpaSpecificationExecutor{
}