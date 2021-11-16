package com.furkankaracam.dsccekilisuygulamasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.furkankaracam.dsccekilisuygulamasi.databinding.ActivityMainBinding

lateinit var binding: ActivityMainBinding
var participantList= mutableListOf<Participant>()
var winnerParticipant=Participant(fullName = "",dscName = "")

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rollTheWinnerButton.setOnClickListener {
            rollTheWinner()
        }
        binding.addParticipantButton.setOnClickListener {
            addParticipant()
        }
    }

    fun rollTheWinner(){
        if(participantList.count() == 0){
            binding.infoText.text="Daha fazla katılım gerek!"
        }
        else{
            winnerParticipant= participantList.random()
            binding.winnerFullNameTextView.text= winnerParticipant.fullName
            binding.winnerDSCNameTextView.text= winnerParticipant.dscName
        }
    }

    fun addParticipant(){
        var fullNameString=binding.fullNameEditText.text.toString()
        var DSCNameString=binding.DSCNameEditText.text.toString()
        if(TextUtils.isEmpty(fullNameString) || TextUtils.isEmpty(DSCNameString)){
            binding.infoText.text="Ad Soyad Eksik"
        }
        else{
            val participant = Participant(fullNameString,DSCNameString)
            participantList.add(participant)
            binding.infoText.text="${participant.fullName} added to list!"
            binding.fullNameEditText.text.clear()
            binding.DSCNameEditText.text.clear()
        }
    }
}

class Participant(val fullName:String, val dscName:String){

}