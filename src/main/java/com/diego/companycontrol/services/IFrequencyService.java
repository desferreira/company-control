package com.diego.companycontrol.services;

import com.diego.companycontrol.data.entities.Employee;
import com.diego.companycontrol.data.entities.Frequency;
import com.diego.companycontrol.data.forms.FrequencyForm;

import java.util.List;

public interface IFrequencyService {

    Frequency registerFrequencyFromForm(FrequencyForm form, Employee employee);

    Frequency saveFrequency(Frequency frequency);

    Frequency findFrequencyById(Long id);

}
