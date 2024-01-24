package hu.byhi.personregister.repository;

import hu.byhi.personregister.entity.Address;
import hu.byhi.personregister.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
