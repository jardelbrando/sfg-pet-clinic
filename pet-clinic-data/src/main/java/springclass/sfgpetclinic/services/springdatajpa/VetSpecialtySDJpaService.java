package springclass.sfgpetclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import springclass.sfgpetclinic.model.Specialty;
import springclass.sfgpetclinic.repositories.SpecialtyRepository;
import springclass.sfgpetclinic.services.SpecialtyService;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : Jardel Brandão
 * @created : 17/03/2025
 **/
@Service
@Profile("springdatajpa")
public class VetSpecialtySDJpaService implements SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    public VetSpecialtySDJpaService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> specialties = new HashSet<>();
        specialtyRepository.findAll().forEach(specialties::add);
        return specialties;
    }

    @Override
    public Specialty findById(Long aLong) {
        return specialtyRepository.findById(aLong).orElse(null);
    }

    @Override
    public Specialty save(Specialty object) {
        return specialtyRepository.save(object);
    }

    @Override
    public void delete(Specialty object) {
        specialtyRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialtyRepository.deleteById(aLong);
    }
}
