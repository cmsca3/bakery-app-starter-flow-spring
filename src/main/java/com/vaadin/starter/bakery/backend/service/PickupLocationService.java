package com.vaadin.starter.bakery.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.vaadin.starter.bakery.backend.data.entity.PickupLocation;
import com.vaadin.starter.bakery.backend.data.entity.User;
import com.vaadin.starter.bakery.backend.repositories.PickupLocationRepository;

/**
 * Serviço responsável por gerenciar operações relacionadas a {@link PickupLocation}.
 *
 * Ele fornece métodos de consulta com filtro, contagem de registros e criação de
 * novas instâncias de {@link PickupLocation}, integrando-se com o repositório
 * {@link PickupLocationRepository}.
 */
@Service
public class PickupLocationService implements FilterableCrudService<PickupLocation> {

    private final PickupLocationRepository pickupLocationRepository;

    /**
     * Construtor que injeta a dependência do repositório de locais de coleta.
     *
     * @param pickupLocationRepository repositório para manipulação de entidades {@link PickupLocation}
     */
    @Autowired
    public PickupLocationService(PickupLocationRepository pickupLocationRepository) {
        this.pickupLocationRepository = pickupLocationRepository;
    }

    /**
     * Busca locais de coleta que correspondem ao filtro informado (ignora maiúsculas e minúsculas).
     * Caso o filtro esteja vazio, retorna todos os locais.
     * @param filter   filtro opcional para pesquisar pelo nome
     * @param pageable objeto {@link Pageable} para paginação e ordenação
     * @return página contendo os locais de coleta encontrados
     */
    public Page<PickupLocation> findAnyMatching(Optional<String> filter, Pageable pageable) {
        if (filter.isPresent()) {
            String repositoryFilter = "%" + filter.get() + "%";
            return pickupLocationRepository.findByNameLikeIgnoreCase(repositoryFilter, pageable);
        } else {
            return pickupLocationRepository.findAll(pageable);
        }
    }

    /**
     * Conta a quantidade de locais de coleta que correspondem ao filtro informado.
     * Caso o filtro esteja vazio, retorna a contagem total.
     *
     * @param filter filtro opcional para pesquisar pelo nome
     * @return número de locais de coleta encontrados
     */
    public long countAnyMatching(Optional<String> filter) {
        if (filter.isPresent()) {
            String repositoryFilter = "%" + filter.get() + "%";
            return pickupLocationRepository.countByNameLikeIgnoreCase(repositoryFilter);
        } else {
            return pickupLocationRepository.count();
        }
    }

    /**
     * Retorna o local de coleta padrão.
     *
     * Atualmente, considera o primeiro local encontrado na busca sem filtros.
     *
     * @return local de coleta padrão
     */
    public PickupLocation getDefault() {
        return findAnyMatching(Optional.empty(), PageRequest.of(0, 1)).iterator().next();
    }

    /**
     * Retorna o repositório JPA utilizado por este serviço.
     *
     * @return instância de {@link JpaRepository} para {@link PickupLocation}
     */
    @Override
    public JpaRepository<PickupLocation, Long> getRepository() {
        return pickupLocationRepository;
    }

    /**
     * Cria uma nova instância de {@link PickupLocation}.
     *
     * @param currentUser usuário atual (não utilizado neste caso, mas necessário pela interface)
     * @return nova instância de {@link PickupLocation}
     */
    @Override
    public PickupLocation createNew(User currentUser) {
        return new PickupLocation();
    }
}
