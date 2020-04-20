package com.diego.companycontrol.services.implementation;

import com.diego.companycontrol.data.entities.Employee;
import com.diego.companycontrol.data.entities.Frequency;
import com.diego.companycontrol.data.entities.enums.FrequencyStatus;
import com.diego.companycontrol.data.forms.FrequencyForm;
import com.diego.companycontrol.repositories.FrequencyRepository;
import com.diego.companycontrol.services.IFrequencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FrequencyServiceImpl implements IFrequencyService {

    @Autowired
    private FrequencyRepository frequencyRepository;

    @Override
    public Frequency registerFrequencyFromForm(FrequencyForm form, Employee employee) {
        FrequencyStatus status;
        if (form.finalHour != null){
            status = FrequencyStatus.CLOSED;
        }else {
            status = FrequencyStatus.OPEN;
        }
        return new Frequency(form.startHour, form.finalHour, employee, status);
    }

    @Override
    public Frequency saveFrequency(Frequency frequency) {
        return this.frequencyRepository.save(frequency);
    }

    @Override
    public Frequency findFrequencyById(Long id) {
        Optional<Frequency> optionalFrequency = this.frequencyRepository.findById(id);
        if(optionalFrequency.isPresent()){
            return optionalFrequency.get();
        }
        return null;
    }

}
