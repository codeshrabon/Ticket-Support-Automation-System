package com.ticket_support_automation_system.ticket_support_automation_system.model;

import com.ticket_support_automation_system.ticket_support_automation_system.model.enums.UserEnums.UserDepartments;
import com.ticket_support_automation_system.ticket_support_automation_system.model.enums.UserEnums.UserJobTitles;
import com.ticket_support_automation_system.ticket_support_automation_system.model.enums.UserEnums.UserRoles;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
	private String userId;
	private String userName;
	private String userDateOfBirth;
	private String userPhone;
	private String userEmail;
	private String userPassword;

    @Enumerated(EnumType.STRING)
	private UserRoles userRole;


    @Enumerated(EnumType.STRING)
	private UserDepartments userDepartment;
    @Enumerated(EnumType.STRING)
	private UserJobTitles userJobTitle;

	private String userDateOfJoining;
	private String userPresentAddress;
	private String userPermanentAddress;
	private String userEmergencyContactName;
	private String userEmergencyContactPhone;

	private String userCreatedBy;
    private String userUpdatedBy;

    @CreatedDate
    private LocalDateTime userCreatedAt;
    @LastModifiedDate
	private LocalDateTime userUpdatedAt;


    //one user -> many comments
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<TicketComments> comments = new ArrayList<>();

}
