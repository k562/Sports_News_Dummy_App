package com.example.sportsnews

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.sportsnews.Fragments.RankingFragment
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.User
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class SignUpPage : AppCompatActivity() {

    lateinit var textsignin : TextView
    lateinit var userName : TextInputEditText
    lateinit var userEmail : TextInputEditText
    lateinit var userPassword : TextInputEditText
    lateinit var userImage : ImageView
    lateinit var userImageUri : Uri
    lateinit var firebaseStorage: FirebaseStorage
    lateinit var userConfirmPassword : TextInputEditText
    lateinit var firebaseAuth : FirebaseAuth
    lateinit var firebaseDatabase: FirebaseDatabase
    lateinit var database: DatabaseReference
    lateinit var btnsignup : Button

    private lateinit var imagePickerLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_page)

        window.setStatusBarColor(Color.parseColor("#03A9F4"))



        textsignin = findViewById(R.id.txtsignin)
        userName = findViewById(R.id.userName)
        userEmail = findViewById(R.id.userEmail)
        userImage = findViewById(R.id.userImage)
        userPassword = findViewById(R.id.userPassword)
        btnsignup = findViewById(R.id.Btn_signup)
        userConfirmPassword = findViewById(R.id.userConfirmPassword)

         var email: String? = null //

         var imageStorageRef: StorageReference? = null

         var userImageUri: Uri? = null

        firebaseAuth = FirebaseAuth.getInstance()

        firebaseDatabase = FirebaseDatabase.getInstance()

        firebaseStorage = FirebaseStorage.getInstance()
        database = firebaseDatabase.reference

        textsignin.setOnClickListener {

            val intent = Intent(this@SignUpPage, LoginPage :: class.java)
            startActivity(intent)
        }

        btnsignup.setOnClickListener {

            signUpUser()

        }

        userImage.setOnClickListener {

            openImagePicker()
        }

        imagePickerLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                data?.data?.let { uri ->
                    userImageUri = uri
                    userImage.setImageURI(userImageUri)
                }
            }
        }

    }









    private fun openImagePicker(){

        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        imagePickerLauncher.launch(intent)

    }
    companion object {
        private const val PICK_IMAGE_REQUEST_CODE = 100
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, PICK_IMAGE_REQUEST_CODE)

        if (requestCode == PICK_IMAGE_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            val selectedImageUri: Uri = data.data ?: return

            // Now, you can use the selectedImageUri to display the selected image in the ImageView
            userImage.setImageURI(selectedImageUri)

            // Save the selected image URI to a class-level property for later use (in signUpUser function)
            userImageUri = selectedImageUri


        }

    }
    private fun signUpUser(){

        // Inside the successful completion block for uploading image and saving image URL to the Realtime Database
        val imageStorageRef = firebaseStorage.reference.child("profile_images").child(firebaseAuth.currentUser!!.uid)

        imageStorageRef.downloadUrl.addOnSuccessListener { downloadUri ->
            // Save the image URL to the Realtime Database
            database.child("users").child(firebaseAuth.currentUser!!.uid).child("imageUri").setValue(downloadUri.toString())
                .addOnCompleteListener { imageUriSaveTask ->
                    if (imageUriSaveTask.isSuccessful) {
                        // Image URL saved successfully, proceed with other user details
                        Toast.makeText(this@SignUpPage, "Account Created Successfully", Toast.LENGTH_SHORT).show()

                        // Pass the image URL and email to the ProfileFragment
                        val bundle = Bundle()
                        bundle.putString("userImageUri", downloadUri.toString())
                        bundle.putString("userEmail", userEmail.text.toString())
                        val profileFragment = RankingFragment()
                        profileFragment.arguments = bundle

                        // Start the LoginActivity after successfully signing up the user
                        val intent = Intent(this@SignUpPage, LoginPage::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        // Error saving image URL
                        Toast.makeText(this@SignUpPage, "Failed to save image URL", Toast.LENGTH_SHORT).show()
                    }
                }
        }

        val name : String = userName.text.toString()
        val email : String = userEmail.text.toString()
        val password : String = userPassword.text.toString()
        val confirmPassword : String = userConfirmPassword.text.toString()



        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() ) {

           if (name.isEmpty()){

               userName.setError("Please Enter Your Name")
           }

            if (email.isEmpty()){

                userEmail.setError("Please Enter Your Email")
            }

            if (password.isEmpty()){

                userPassword.setError("Please Enter Your Password")
            }

            if (confirmPassword.isEmpty()){

                userConfirmPassword.setError("Please Enter Your Password Again")
            }

            Toast.makeText(this,"Please Fill All The Fields",Toast.LENGTH_SHORT).show()

        } else if (password != confirmPassword) {

            Toast.makeText(this, "Password Does Not Match", Toast.LENGTH_SHORT).show()
        } else {

                firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this){
                    if (it.isSuccessful){

                        // Upload the user image to Firebase Storage
                        val imageStorageRef = firebaseStorage.reference.child("profile_images").child(firebaseAuth.currentUser!!.uid)
                        userImageUri?.let { uri ->
                            imageStorageRef.putFile(uri).addOnCompleteListener { imageUploadTask ->
                                if (imageUploadTask.isSuccessful) {
                                    // Image upload successful, get the download URL
                                    imageStorageRef.downloadUrl.addOnSuccessListener { downloadUri ->
                                        // Save the image URL to the Realtime Database
                                        database.child("users").child(firebaseAuth.currentUser!!.uid).child("imageUri").setValue(downloadUri.toString())
                                            .addOnCompleteListener { imageUriSaveTask ->
                                                if (imageUriSaveTask.isSuccessful) {
                                                    // Image URL saved successfully, proceed with other user details
                                                    Toast.makeText(this@SignUpPage, "Account Created Successfully", Toast.LENGTH_SHORT).show()

                                                    val intent = Intent(this@SignUpPage, LoginPage::class.java)
                                                    startActivity(intent)
                                                    finish()
                                                } else {
                                                    // Error saving image URL
                                                    Toast.makeText(this@SignUpPage, "Failed to save image URL", Toast.LENGTH_SHORT).show()
                                                }
                                            }
                                    }
                                } else {
                                    // Error uploading image
                                    Toast.makeText(this@SignUpPage, "Failed to upload image", Toast.LENGTH_SHORT).show()
                                }
                            }
                        }
                    } else {
                        // ... (Existing code)
                    }

                        val database = firebaseDatabase.reference.child("users").child(firebaseAuth.currentUser!!.uid)

                        val users : users = users(name,email,password,confirmPassword,firebaseAuth.currentUser!!.uid)


                        database.setValue(users).addOnCompleteListener(this){

                            if (it.isSuccessful){

                                Toast.makeText(this@SignUpPage, "Account Created Successfully", Toast.LENGTH_SHORT).show()

                                val intent = Intent(this@SignUpPage, LoginPage :: class.java)
                                startActivity(intent)
                                finish()

                            } else {

                                Toast.makeText(this,"Account Creation Failed",Toast.LENGTH_SHORT).show()
                            }

                        }


                }
        }






        if (name.isBlank() || email.isBlank() || password.isBlank() || confirmPassword.isBlank() ) {

            Toast.makeText(this,"Please Fill All The Fields",Toast.LENGTH_SHORT).show()
            return
        }

        if(password != confirmPassword){

            Toast.makeText(this,"Password Does Not Match",Toast.LENGTH_SHORT).show()
            return

        }


        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this){


         if (it.isSuccessful){

                Toast.makeText(this@SignUpPage, "Account Created Successfully", Toast.LENGTH_SHORT).show()

                val intent = Intent(this@SignUpPage, LoginPage :: class.java)
                startActivity(intent)
                finish()


         } else {

             Toast.makeText(this,"Account Creation Failed",Toast.LENGTH_SHORT).show()
         }


        }

    }
}