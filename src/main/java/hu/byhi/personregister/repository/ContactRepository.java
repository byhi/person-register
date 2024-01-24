package hu.byhi.personregister.repository;

import hu.byhi.personregister.entity.Address;
import hu.byhi.personregister.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
