package com.example.laboratorio05.ui.movie

import android.media.audiofx.AudioEffect.Descriptor
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import com.example.laboratorio05.R
import com.example.laboratorio05.data.model.MovieModel
import java.util.Locale.Category
import javax.crypto.spec.DESKeySpec
import javax.microedition.khronos.egl.EGLDisplay

class NewMovieFragment : Fragment() {

    private lateinit var NameEditText : EditText
    private lateinit var CategoryEditText : EditText
    private lateinit var DescriptionEditText : EditText
    private lateinit var CalificationEditText : EditText
    private lateinit var SubmitButton : Button

    private val movieViewModel : MovieViewModel by activityViewModels { MovieViewModel.Factory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        NameEditText = view.findViewById(R.id.NameEditText)
        CategoryEditText = view.findViewById(R.id.CategoryEditText)
        DescriptionEditText = view.findViewById(R.id.DescriptionEditText)
        CalificationEditText = view.findViewById(R.id.CalificationEditText)
        SubmitButton = view.findViewById(R.id.SubmitButton)

        SubmitButton.setOnClickListener{
            var Name = NameEditText.text.toString()
            var Category = CategoryEditText.toString()
            var Description = DescriptionEditText.text.toString()
            var Calification = CalificationEditText.text.toString()
            var NewMovie = MovieModel(Name, Category, Description, Calification)
            movieViewModel.addMovies(NewMovie)
            Log.d("Movie", movieViewModel.getMovies().toString())
        }
    }

}