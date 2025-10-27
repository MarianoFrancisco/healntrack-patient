package com.sa.healntrack.patient_service.patient.application.port.out.persistence;

public interface ExistsPatientByCui {

    boolean exists(String cui);

}
