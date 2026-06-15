class Student {
    // Required fields
    private String name;
    private int rollNumber;

    // Optional fields
    private String email;
    private String phone;
    private String address;

    // Private constructor - only Builder can create Student
    private Student(Builder builder) {
        this.name = builder.name;
        this.rollNumber = builder.rollNumber;
        this.email = builder.email;
        this.phone = builder.phone;
        this.address = builder.address;
    }

    @Override
    public String toString() {
        return "Student{name=" + name +
                ", rollNumber=" + rollNumber +
                ", email=" + email +
                ", phone=" + phone +
                ", address=" + address + "}";
    }

    // Static nested Builder class
    static class Builder {
        // Required fields
        private String name;
        private int rollNumber;

        // Optional fields
        private String email;
        private String phone;
        private String address;

        // Constructor with required fields only
        public Builder(String name, int rollNumber) {
            this.name = name;
            this.rollNumber = rollNumber;
        }

        // Each optional field has its own method
        // Each method returns Builder so you can chain
        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder phone(String phone) {
            // set phone and return this
            this.phone = phone;
            return this;
        }

        public Builder address(String address) {
            // set address and return this
            this.address=address;
            return this;
        }

        // Final method that creates the Student
        public Student build() {
            return new Student(this);
        }
    }
}

class Exercise6 {
    public static void main(String[] args) {
        // Student with all fields
        Student s1 = new Student.Builder("Shivangi", 101)
                .email("shivangi@gmail.com")
                .phone("9876543210")
                .address("Bhubaneswar")
                .build();

        // Student with only required fields
        Student s2 = new Student.Builder("Rahul", 102)
                .build();

        // Student with some optional fields
        Student s3 = new Student.Builder("Priya", 103)
                .email("priya@gmail.com")
                .build();

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}