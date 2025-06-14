package mataffi.service;

import jakarta.persistence.EntityNotFoundException;
import mataffi.entity.User;
import mataffi.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
    }

    @Transactional
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));

        user.setName(userDetails.getName());
        user.setUsername(userDetails.getUsername());
        user.setEmail(userDetails.getEmail());
        user.setPhone(userDetails.getPhone());
        user.setWebsite(userDetails.getWebsite());

        // Update nested objects
        if (userDetails.getAddress() != null) {
            if (user.getAddress() == null) {
                user.setAddress(userDetails.getAddress());
            } else {
                user.getAddress().setStreet(userDetails.getAddress().getStreet());
                user.getAddress().setSuite(userDetails.getAddress().getSuite());
                user.getAddress().setCity(userDetails.getAddress().getCity());
                user.getAddress().setZipcode(userDetails.getAddress().getZipcode());
                if (userDetails.getAddress().getGeo() != null) {
                    if (user.getAddress().getGeo() == null) {
                        user.getAddress().setGeo(userDetails.getAddress().getGeo());
                    } else {
                        user.getAddress().getGeo().setLat(userDetails.getAddress().getGeo().getLat());
                        user.getAddress().getGeo().setLng(userDetails.getAddress().getGeo().getLng());
                    }
                }
            }
        }

        if (userDetails.getCompany() != null) {
            if (user.getCompany() == null) {
                user.setCompany(userDetails.getCompany());
            } else {
                user.getCompany().setName(userDetails.getCompany().getName());
                user.getCompany().setCatchPhrase(userDetails.getCompany().getCatchPhrase());
                user.getCompany().setBs(userDetails.getCompany().getBs());
            }
        }

        return userRepository.save(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
        userRepository.delete(user);
    }
}
