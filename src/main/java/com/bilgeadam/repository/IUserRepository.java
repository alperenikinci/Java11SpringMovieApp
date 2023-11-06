package com.bilgeadam.repository;

import com.bilgeadam.dto.response.FindAllResponseDto;
import com.bilgeadam.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {

    List<User> findAllByOrderByName(); //Name e gore siralama yap, sonra her seyi don.

//    List<User> findAllByNameContaining(String value);
    List<User> findAllByNameContainingIgnoreCase(String value);
    List<User> findAllByEmailContainingIgnoreCase(String value);
    List<User> findAllByEmailEndingWith(String value);
    Optional<User> findOptionalByEmailAndPassword(String email, String password);

    // Passwordunun uzunluğu belirediğimiz sayıdan buyuk olanlar (Query yazılacak);
    @Query(value = "SELECT * FROM tbl_user WHERE length(password)>?1",nativeQuery = true) //Native Query
    List<User> passwordLongerThan1(int value);

    @Query(value = "SELECT u FROM User u WHERE length(u.password)>?1 ") //HQL
    List<User> passwordLongerThan2(int value);

    @Query(value = "SELECT u FROM User u WHERE length(u.password)>:x ") //HQL
    List<User> passwordLongerThan3(@Param("x") int value);


}
