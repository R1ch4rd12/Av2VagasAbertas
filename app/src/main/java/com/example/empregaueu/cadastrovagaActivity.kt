package com.example.empregaueu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.empregaueu.databinding.ActivityCadastrovagaBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class CadastroVagaActivity : AppCompatActivity() {
    private lateinit var binding : ActivityCadastrovagaBinding
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroVagaBinding.entries(layoutInflater)
        setContentView(binding.root)

        var edEmpresa= binding.edEmpresa
        var edCargo = binding.edSalario
        var edSalario = binding.edCargo
        var btCadatrar = binding.button3

        dbRef = FirebaseDatabase.getInstance().getReference("Empregador")

        btCadatrar.setOnClickListener{
            val empName = edEmpresa.text.toString()
            val empCargo = edCargo.text.toString()
            val empSalario = edSalario.text.toString()

            if(empName.isEmpty()){
                edEmpresa.error = "Por favor insira um nome"
            }
            if(empCargo.isEmpty()){
                edCargo.error = "Por favor insira um Cargo"
            }
            if(empSalario.isEmpty()){
                edSalario.error = "Por favor insira um Salário"
            }

            val empId = dbRef.push().key!!

            val empregador = EmpresaModelo(empId, empName, empCargo, empSalario)

            dbRef.child(empId).setValue(empregador)
                .addOnCompleteListener{
                    Toast.makeText(this, "Cadastro realizado", Toast.LENGTH_SHORT).show()

                    edEmpresa.text.clear()
                    edCargo.text.clear()
                    edSalario.text.clear()

                }.addOnFailureListener{err ->
                    Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_SHORT).show()
                }
        }

    }

    class ActivityCadastroVagaBinding {
        companion object {
            fun entries(layoutInflater: LayoutInflater): ActivityCadastrovagaBinding {
                TODO("Not yet implemented")
            }
        }
    }

    private fun EmpresaModelo(
        empId: String,
        empName: String,
        empCargo: String,
        empSalario: String
    ) {
    }


}

private fun CadastroVagaActivity.ActivityCadastroVagaBinding.Companion.entries(layoutInflater: LayoutInflater): ActivityCadastrovagaBinding {
    TODO("Not yet implemented")
}


