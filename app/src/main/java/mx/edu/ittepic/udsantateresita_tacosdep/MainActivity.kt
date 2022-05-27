package mx.edu.ittepic.udsantateresita_tacosdep

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.LocationServices
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.GeoPoint
import mx.edu.ittepic.udsantateresita_tacosdep.R.drawable
import mx.edu.ittepic.udsantateresita_tacosdep.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var baseRemota = FirebaseFirestore.getInstance()
    var posicion = ArrayList<Data>()
    lateinit var locacion : LocationManager
    var cambioImagen = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),1)
        }

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        baseRemota.collection("santateresita")
            .addSnapshotListener { querySnapshot, error ->
                //query tiene muchos documento que es equivalente al cursor del sqlite
                if (error != null) {
                    //SI UBO ERROR!
                    AlertDialog.Builder(this)
                        .setMessage(error.message)
                        .show()
                    return@addSnapshotListener
                }

                var resultado = ""
                posicion.clear()
                for (documento in querySnapshot!!) {
                    var data = Data()
                    data.nombre = documento.getString("nombre").toString()
                    data.descripcion = documento.getString("descripcion").toString()
                    data.posicion1 = documento.getGeoPoint("posicion1")!!
                    data.posicion2 = documento.getGeoPoint("posicion2")!!
                    resultado += data.toString()+"\n\n"
                    posicion.add(data)
                }
                //binding.descripcion.setText(resultado)
                //binding.verImagenes.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arreglo)

            }

        binding.sigImagen.setOnClickListener {
            if (binding.nombre.text.toString() == "CANCHAS DE BASQUETBOL"){
                if (cambioImagen){
                    binding.sigImagen.setImageResource(R.drawable.canchabasquetbol2)
                    cambioImagen = false
                }else{
                    binding.sigImagen.setImageResource(R.drawable.canchabasquetbol3)
                    cambioImagen = true
                }
            }
            if (binding.nombre.text.toString() == "CANCHAS DE FRONTENIS"){
                if (cambioImagen){
                    binding.sigImagen.setImageResource(R.drawable.canchafrontenis1)
                    cambioImagen = false
                }else{
                    binding.sigImagen.setImageResource(R.drawable.canchafrontenis2)
                    cambioImagen = true
                }
            }
            if (binding.nombre.text.toString() == "CENTRO DE DESARROLLO COMUNITARIO"){
                if (cambioImagen){
                    binding.sigImagen.setImageResource(R.drawable.desarrollocomunitario1)
                    cambioImagen = false
                }else{
                    binding.sigImagen.setImageResource(R.drawable.centrodsarrollo2)
                    cambioImagen = true
                }
            }
            if (binding.nombre.text.toString() == "CAMPO DE FUTBOL 1"){
                if (cambioImagen){
                    binding.sigImagen.setImageResource(R.drawable.canchaunofutbol1)
                    cambioImagen = false
                }else{
                    binding.sigImagen.setImageResource(R.drawable.futboluno2)
                    cambioImagen = true
                }
            }
            if (binding.nombre.text.toString() == "CAMPO DE FUTBOL 2"){
                if (cambioImagen){
                    binding.sigImagen.setImageResource(R.drawable.futboldos1)
                    cambioImagen = false
                }else{
                    binding.sigImagen.setImageResource(R.drawable.futboldos2)
                    cambioImagen = true
                }
            }
            if (binding.nombre.text.toString() == "ESCUELA SECUNDARIA FEDERAL REY NAYAR"){
                if (cambioImagen){
                    binding.sigImagen.setImageResource(R.drawable.secureynayar1)
                    cambioImagen = false
                }else{
                    binding.sigImagen.setImageResource(R.drawable.secureynayar2)
                    cambioImagen = true
                }
            }
            if (binding.nombre.text.toString() == "CANCHA DE SOFTBOL UNIDAD DEPORTIVA SANTA TERESITA A"){
                if (cambioImagen){
                    binding.sigImagen.setImageResource(R.drawable.canchasoftbol2)
                    cambioImagen = false
                }else{
                    binding.sigImagen.setImageResource(R.drawable.canchasoftbol3)
                    cambioImagen = true
                }
            }
            if (binding.nombre.text.toString() == "DIAMANTE DE BEISBOL SANTA TERESITA"){
                if (cambioImagen){
                    binding.sigImagen.setImageResource(R.drawable.diamantebeisbol1)
                    cambioImagen = false
                }else{
                    binding.sigImagen.setImageResource(R.drawable.diamantebeisbol2)
                    cambioImagen = true
                }
            }
            if (binding.nombre.text.toString() == "ESTADIO OLIMPICO SANTA TERESITA"){
                if (cambioImagen){
                    binding.sigImagen.setImageResource(R.drawable.estadioolimpico1)
                    cambioImagen = false
                }else{
                    binding.sigImagen.setImageResource(R.drawable.estadioolimpico2)
                    cambioImagen = true
                }
            }
            if (binding.nombre.text.toString() == "CENTRO CAIM"){
                if (cambioImagen){
                    binding.sigImagen.setImageResource(R.drawable.centrocaim1)
                    cambioImagen = false
                }else{
                    binding.sigImagen.setImageResource(R.drawable.centrocaim2)
                    cambioImagen = true
                }
            }
            if (binding.nombre.text.toString() == "CAMPO DE BEISBOL"){
                if (cambioImagen){
                    binding.sigImagen.setImageResource(R.drawable.canchabeisboll2)
                    cambioImagen = false
                }else{
                    binding.sigImagen.setImageResource(R.drawable.canchasobtbol1)
                    cambioImagen = true
                }
            }
            if (binding.nombre.text.toString() == "CANCHAS DE FRONTENIS"){
                if (cambioImagen){
                    binding.sigImagen.setImageResource(R.drawable.canchafrontenis1)
                    cambioImagen = false
                }else{
                    binding.sigImagen.setImageResource(R.drawable.canchafrontenis2)
                    cambioImagen = true
                }
            }


        }
        //binding.ubicacion.setOnClickListener { miUbicacion() }

        locacion = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        var oyente = Oyente(this)
        locacion.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,01f,oyente)

    }



    private fun miUbicacion() {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        LocationServices.getFusedLocationProviderClient(this)
            .lastLocation.addOnSuccessListener {
                var geoPosicion = GeoPoint(it.latitude,it.longitude)
                //binding.nombre.setText("${it.latitude},${it.longitude}")
                for (item in posicion){
                    if (item.estoyEn(geoPosicion)){
                        binding.nombre.setText(item.nombre)
                        binding.descripcion.setText(item.descripcion)
                    }else{
                        binding.nombre.setText("No se pudo encontrar su ubicacion")
                        binding.descripcion.setText("Sentimos las molestias")
                    }
                }
            }.addOnFailureListener {
                binding.nombre.setText("ERROR AL OBTENER UBICACION")
            }
    }
}

class Oyente (puntero:MainActivity): LocationListener {
    var p = puntero

    override fun onLocationChanged(location: Location) {
        p.binding.cordenadas.setText("Latitud: ${location.latitude}, Longitud: ${location.longitude}")
        p.binding.nombre.setText("Estas en la Unidad Deportiva Santa Teresita")
        var geoPosicionGPS = GeoPoint(location.latitude, location.longitude)

        for (item in p.posicion) {
            if (item.estoyEn(geoPosicionGPS)) {
                p.binding.nombre.setText(item.nombre)
                p.binding.descripcion.setText(item.descripcion)
            }
        }
    }
        override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
        }

        override fun onProviderEnabled(provider: String) {
        }

        override fun onProviderDisabled(provider: String) {
        }

    }

