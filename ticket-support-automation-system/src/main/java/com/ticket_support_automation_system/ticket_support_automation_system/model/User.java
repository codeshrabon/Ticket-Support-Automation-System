package com.ticket_support_automation_system.ticket_support_automation_system.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ticket_support_automation_system.ticket_support_automation_system.model.enums.UserEnums.UserDepartments;
import com.ticket_support_automation_system.ticket_support_automation_system.model.enums.UserEnums.UserJobTitles;
import com.ticket_support_automation_system.ticket_support_automation_system.model.enums.UserEnums.UserRoles;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "User ID id required" )
	private String userId;

    @NotBlank(message = "User name is required")
	private String userName;

    /*@Past(message = "Date of birth must be in the past")
    @JsonFormat(pattern = "yyyy-MM-dd")*/
	private String userDateOfBirth;

    @Pattern(regexp = "^[0-9]{10,15}", message = "Phone number must be 10-15 digits")
	private String userPhone;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Column(unique = true)
	private String userEmail;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 character long")
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

    @Pattern(regexp = "^[0-9]{10,15}", message = "Phone number must be 10-15 digits")
	private String userEmergencyContactPhone;

	private String userCreatedBy;
    private String userUpdatedBy;



    @CreatedDate
    private LocalDateTime userCreatedAt;
    @LastModifiedDate
	private LocalDateTime userUpdatedAt;

    // Tickets created by this user
    @OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"createdBy","updatedBy","ticketAssignedTo","comments","attachments","group","category","subcategory"})
    private List<Ticket> ticketsCreated = new ArrayList<>();

    // Tickets last updated by this user
    @OneToMany(mappedBy = "updatedBy", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"createdBy","updatedBy","ticketAssignedTo","comments","attachments","group","category","subcategory"})
    private List<Ticket> ticketsUpdated = new ArrayList<>();

    // Tickets assigned to this user
    @OneToMany(mappedBy = "ticketAssignedTo", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"createdBy","updatedBy","ticketAssignedTo","comments","attachments","group","category","subcategory"})
    private List<Ticket> ticketsAssigned = new ArrayList<>();


    //comments by the user
    //one user -> many comments
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<TicketComments> comments = new ArrayList<>();

    /*// one user -> many ticket
    @OneToMany(mappedBy = "ticket",cascade = CascadeType.ALL)
    private List<Ticket> tickets = new ArrayList<>();
*/
}
