package baithi.tuentpd01983.ClassGenerate;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import baithi.tuentpd01983.entity.Role;
import baithi.tuentpd01983.entity.User;
import baithi.tuentpd01983.repository.RoleRepository;
import baithi.tuentpd01983.repository.UserRepository;

@Component
public class AutoCreateRole implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired 
    private PasswordEncoder passwordEncoder;
    
    @Autowired 
    private RegisterUserArea RegisterUserArea;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {
    	
    
  
    	
    	if (roleRepository.findByNameRole("USER") == null) {
            roleRepository.save(new Role(new Long(1),"USER"));
        }

        // Roles
        if (roleRepository.findByNameRole("ADMIN") == null) {
            roleRepository.save(new Role(new Long(2),"ADMIN"));
        }
     
        // Admin account
        if (userRepository.findByUserName("tritue12") == null) {
            User admin = new User();
            admin.setUserName("tritue12");
            admin.setPasswordEcryted(passwordEncoder.encode("12"));
            HashSet<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByNameRole("ADMIN"));
            admin.setActive(true);
            admin.setFullName("tritue");
            admin.setRoles(roles);
           System.out.println("dsvdsvdsvdvds");
            userRepository.save(admin);
            RegisterUserArea.AutoCreateAreaDevice(admin);
            
        }
        
        if (userRepository.findByUserName("vannhamb") == null) {
            User user = new User();
            user.setUserName("vannhamb");
            user.setPasswordEcryted(passwordEncoder.encode("12"));
            HashSet<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByNameRole("USER"));
            user.setActive(true);
            user.setFullName("tritue");
            user.setRoles(roles);
           System.out.println("ávsavsasvsa");
            userRepository.save(user);
            RegisterUserArea.AutoCreateAreaDevice(user);
        }

       
 }
    
    

}
