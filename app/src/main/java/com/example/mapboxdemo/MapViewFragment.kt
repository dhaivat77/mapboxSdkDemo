package com.example.mapboxdemo

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.google.gson.Gson
import com.mapbox.maps.CameraOptions
import com.mapbox.maps.MapView
import com.mapbox.maps.Style
import com.mapbox.maps.plugin.annotation.AnnotationConfig
import com.mapbox.maps.plugin.annotation.annotations
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationManager
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationOptions
import com.mapbox.maps.plugin.annotation.generated.createPointAnnotationManager


class MapViewFragment : Fragment() {
    var mapView: MapView? = null
    var llMapView:FrameLayout?=null
    var btnGoToSecondFragment:AppCompatButton?=null
    var pointAnnotationManager: PointAnnotationManager? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_map_view, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mapView = MapView(requireContext())
        mapView?.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.white))
        llMapView = view.findViewById<FrameLayout>(R.id.llMapView)
        llMapView?.removeAllViews()
        llMapView?.addView(mapView)

        mapView?.getMapboxMap()?.apply {
            setCamera(
                CameraOptions.Builder()
                    .zoom(11.0)
                    .build()
            )
        }
        mapView?.getMapboxMap()?.loadStyleUri(Style.MAPBOX_STREETS)
    }
}