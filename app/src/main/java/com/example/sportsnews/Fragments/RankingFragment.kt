package com.example.sportsnews.Fragments

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.sportsnews.EditProfile
import com.example.sportsnews.FragmentPager
import com.example.sportsnews.R
import com.example.sportsnews.RankingPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage


class RankingFragment : Fragment() {


     lateinit var settings  : RelativeLayout
//     lateinit var switchNightmode : Switch
     lateinit var toolbarprofile : Toolbar
     lateinit var logout2  : RelativeLayout
     lateinit var sharetheApp : RelativeLayout
     lateinit var Btn_edit : AppCompatButton
     lateinit var userImage : ImageView
     lateinit var Rate : RelativeLayout
     lateinit var notification_switch : Switch
     lateinit var userEmail : TextView

     lateinit var firebaseStorage: FirebaseStorage
     lateinit var firebaseDatabase: FirebaseDatabase
     lateinit var firebaseAuth: FirebaseAuth



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_ranking, container, false)

       settings = view.findViewById(R.id.Settings)
//         switchNightmode = view.findViewById(R.id.SwitchNightMode)
        logout2 = view.findViewById(R.id.logout2)
        sharetheApp = view.findViewById(R.id.sharetheApp)
        Btn_edit = view.findViewById(R.id.Btn_edit)
        Rate = view.findViewById(R.id.Rate)
        notification_switch = view.findViewById(R.id.notification_switch)
        toolbarprofile = view.findViewById(R.id.Toolbarprofile)
        userImage = view.findViewById(R.id.Img_profile)


       settings.setOnClickListener {
           val settingsIntent = Intent(android.provider.Settings.ACTION_SETTINGS)
           startActivity(settingsIntent)
       }



        toolbarprofile.title = "Profile"


        logout2.setOnClickListener {

            val intent = Intent(activity as Context, com.example.sportsnews.LoginPage::class.java)
            startActivity(intent)

        }

        sharetheApp.setOnClickListener {

            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT , "Hey checkout this Sports news App")
            val chooser = Intent.createChooser(intent , "Share this App using...")
            startActivity(chooser)
        }

        Btn_edit.setOnClickListener {

            val intent = Intent(activity as Context, EditProfile::class.java)
            startActivity(intent)
        }

        Rate.setOnClickListener {

            val appPackageName = "your.package.name"

            val rateIntent = Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$appPackageName"))
            rateIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            try {
                startActivity(rateIntent)
            } catch (e: ActivityNotFoundException) {
                // Handle the case where the Play Store app is not installed
                val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName"))
                startActivity(webIntent)
            }
        }

        notification_switch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // The switch is turned on, so trigger the notification
                triggerNotification()
            } else {
                // The switch is turned off, handle the notification being disabled
                // You can remove the notification or perform any other necessary action
            }
        }


        val window = requireActivity().window
        // Set the status bar color
        window.statusBarColor = Color.parseColor("#03A9F4")

        // Get a reference to the toolbar
        val toolbar = requireActivity().findViewById<Toolbar>(R.id.Toolbar)


        // Hide the title
        toolbar.title = ""


        toolbar.visibility = View.GONE

        loaduserImage()

        return view
    }


    fun loaduserImage() {

        firebaseStorage = FirebaseStorage.getInstance()
        firebaseDatabase = FirebaseDatabase.getInstance()
        firebaseAuth = FirebaseAuth.getInstance()

        val user = firebaseAuth.currentUser
        val userreference = firebaseDatabase.getReference("Users")
        val uid = user!!.uid
        val imagereference = firebaseStorage.getReference("ProfileImages").child(uid)



        // Retrieve the image URL and email from arguments bundle


//        userreference.child("imageUri").get().addOnSuccessListener { dataSnapshot ->
//            val downloadUrl = dataSnapshot.value as? String
//
//            if (!downloadUrl.isNullOrEmpty()) {
//                // Use Glide to load the user image into the profileImageView
//                Glide.with(this)
//                    .load(downloadUrl)
//                    .into(userImage)
//            } else {
//                // If the download URL is empty or null, show a default placeholder image
//                Glide.with(this)
//                    .load(R.drawable.man) // Replace with your default image resource
//                    .into(userImage)
//            }
//        }.addOnFailureListener { exception ->
//            // Error occurred while retrieving the image URL
//            // Show a default placeholder image
//            Glide.with(this)
//                .load(R.drawable.man) // Replace with your default image resource
//                .into(userImage)
//
//        }

    }

    private fun triggerNotification() {
        val notificationManager = requireContext().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val channelId = "your_channel_id" // Replace with your own channel ID

        val channel = NotificationChannel(
            channelId,
            "Channel Name",
            NotificationManager.IMPORTANCE_DEFAULT
        )
        // Customize the channel settings if needed
        notificationManager.createNotificationChannel(channel)

        val notificationBuilder = NotificationCompat.Builder(requireContext(), channelId)
            .setSmallIcon(R.drawable.notification)
            .setContentTitle("Notification Title")
            .setContentText("Notification Content")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        // Show the notification
        notificationManager.notify(0, notificationBuilder.build())
    }

}



