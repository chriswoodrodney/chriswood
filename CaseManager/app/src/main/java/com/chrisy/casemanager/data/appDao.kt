import androidx.room.*
import com.chrisy.casemanager.data.Employee
import kotlinx.coroutines.flow.Flow

@Dao
interface AppDao { // AppDatabase.kt
    @Query("SELECT * FROM cases")
    fun getAllCases()
    @Insert
    fun insertCase()
    @Insert
    fun insertEmployee()
    @Query("SELECT * FROM employees")
    abstract fun getAllEmployees(): Flow<List<Employee>>


}