package lk.ijse.superHardware.dao;

import lk.ijse.superHardware.dto.CustomDTO;

public interface QueryDAO extends SuperDAO{
    void customerOrderDetails(CustomDTO customDTO);
}
