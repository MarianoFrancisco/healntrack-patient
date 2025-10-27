create table patient (
    id uuid primary key,
    cui varchar(13) unique not null,
    full_name varchar(150) not null,
    birth_date date not null,
    gender varchar(6) check (gender in ('MALE', 'FEMALE', 'OTHER')) not null,
    address text not null,
    phone_number varchar(8) not null,
    email varchar(100) not null,
    emergency_phone_number varchar(8) not null,
    created_at timestamp not null,
    updated_at timestamp not null
);

create table consultation (
    id uuid primary key,
    patient_id uuid not null,
    doctor_id uuid not null,
    date date not null,
    diagnosis text not null,
    treatment text,
    notes text,
    fee numeric(10,2) not null,
    created_at timestamp not null,
    updated_at timestamp not null,
    constraint fk_patient foreign key(patient_id) references patient(id)
);
