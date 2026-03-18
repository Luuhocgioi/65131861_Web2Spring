package thiGK.ntu._1.nguyenhoangluu_fitCMS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import thiGK.ntu._1.nguyenhoangluu_fitCMS.models.Page;

@Repository
public interface PageRepository extends JpaRepository<Page, Integer> {

}
