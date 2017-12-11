/**
 * Array based storage for Resumes
 */
import java.util.Arrays;
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0;

    void clear() {
        for(int i = 0; i<size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume r) {

        if( size < storage.length ) {
            storage[size] = r;
            size++;
        } else {
            System.out.println("Хранилище заполнено");
        }
    }

    Resume get(String uuid) {
        for(int i = 0; i<size; i++) {
            if (storage[i] != null && storage[i].toString().equals(uuid)) {
                    return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for(int i = 0; i<size; i++) {
            if (storage[i] != null && storage[i].toString().equals(uuid)) {
                 // переносим в позицию где был удален элемент с послдеднего елемента масива
                storage[i]=storage[size-1];
                storage[size-1] = null;
                size--;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] storagesNew = new Resume[size];

        for(int i = 0; i<size; i++) {
                storagesNew[i] = storage[i];
        }
        return storagesNew;
    }

    int size() {
        return size;
    }
}
