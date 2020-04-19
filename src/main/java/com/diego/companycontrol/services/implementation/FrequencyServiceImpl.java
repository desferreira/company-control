package com.diego.companycontrol.services.implementation;

import com.diego.companycontrol.data.entities.Employee;
import com.diego.companycontrol.data.entities.Frequency;
import com.diego.companycontrol.data.forms.FrequencyForm;
import com.diego.companycontrol.repositories.FrequencyRepository;
import com.diego.companycontrol.services.IFrequencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FrequencyServiceImpl implements IFrequencyService {

    @Autowired
    private FrequencyRepository frequencyRepository;

    @Override
    public Frequency registerFrequencyFromForm(FrequencyForm form, Employee employee) {
        return new Frequency(form.startHour, form.finalHour, employee);
    }

    @Override
    public Frequency saveFrequency(Frequency frequency) {
        return this.frequencyRepository.save(frequency);
    }

}
