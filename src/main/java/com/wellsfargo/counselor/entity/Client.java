package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;

@Entity
public class Client {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long clientId;

        private String name;
        private String email;
        private String phone;

        @ManyToOne
        @JoinColumn(name = "advisor_id", nullable = false)
        private FinancialAdvisor advisor;

        @OneToOne(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
        private Portfolio portfolio;

        public Client() {}

        public Client(String name, String email, String phone, FinancialAdvisor advisor) {
            this.name = name;
            this.email = email;
            this.phone = phone;
            this.advisor = advisor;
        }

        // Getters and setters (no setter for clientId)
    }

