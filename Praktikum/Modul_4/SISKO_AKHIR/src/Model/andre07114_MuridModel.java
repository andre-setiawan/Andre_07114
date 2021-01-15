package Model;

import Entity.andre07114_Murid;

import java.util.ArrayList;

public class andre07114_MuridModel {
    private ArrayList<andre07114_Murid> SiswaArrayList = new ArrayList<>();

    public andre07114_MuridModel() {
        SiswaArrayList  = new ArrayList<andre07114_Murid>();
    }

    public andre07114_Murid getData(int index) {
        return SiswaArrayList.get(index);
    }

    public andre07114_Murid getDataByNis(int nis) {
        for(andre07114_Murid siswa : SiswaArrayList) {
            if(siswa.getNip() == nis) {
                return siswa;
            }
        }
        return null;
    }

    public int getMax() {
        return SiswaArrayList.size();
    }

    public boolean insert(andre07114_Murid siswaEntity) {
        SiswaArrayList.add(siswaEntity);
        if(SiswaArrayList.contains(siswaEntity)) {
            return true;
        }

        return false;
    }

    public boolean update(andre07114_Murid newEric07238SiswaEntity, int nisLama) {
        for(int i = 0; i < SiswaArrayList.size(); i++) {
            if(SiswaArrayList.get(i).getNip() == nisLama) {
                SiswaArrayList.set(i, newEric07238SiswaEntity);
                return true;
            }
        }
        return false;
    }

    public int delete(int nis) {
        int index = cekData(nis);
        if(index != -1 && index != -2) {
            SiswaArrayList.remove(index);
            return 0;
        }

        return index;
    }

    public int cekData(int nis) {
        int index = 0;
        if(SiswaArrayList.size() == 0) {
            index = -1;
        } else {
            for(int i = 0; i < SiswaArrayList.size(); i++) {
                if(SiswaArrayList.get(i).getNip() == nis) {
                    index = i;
                    break;
                } else {
                    index = -2;
                }
            }
        }
        return index;
    }
}
