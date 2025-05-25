package com.example.tercerparcial.presentation.home

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.tercerparcial.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class SendSimActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap
    private lateinit var editTelefono: EditText
    private lateinit var editLatitud: EditText
    private lateinit var editLongitud: EditText
    private lateinit var btnContinuar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_sim)

        editTelefono = findViewById(R.id.editTextTelefono)
        editLatitud = findViewById(R.id.editTextLatitud)
        editLongitud = findViewById(R.id.editTextLongitud)
        btnContinuar = findViewById(R.id.btnContinuar)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment
        mapFragment.getMapAsync(this)

        btnContinuar.setOnClickListener {
            val tel = editTelefono.text.toString()
            val lat = editLatitud.text.toString()
            val lon = editLongitud.text.toString()

            if (tel.isNotBlank() && lat.isNotBlank() && lon.isNotBlank()) {
                Toast.makeText(this, "Enviando SIM a $tel\n$lat, $lon", Toast.LENGTH_LONG).show()
                // Aquí podrías guardar en Firebase si se requiere
            } else {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        val bolivia = LatLng(-16.5, -68.15)
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(bolivia, 6f))

        map.setOnMapClickListener { latLng ->
            map.clear()
            map.addMarker(MarkerOptions().position(latLng).title("Ubicación seleccionada"))
            editLatitud.setText(latLng.latitude.toString())
            editLongitud.setText(latLng.longitude.toString())
        }
    }
}