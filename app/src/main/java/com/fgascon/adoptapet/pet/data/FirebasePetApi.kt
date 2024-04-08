package com.fgascon.adoptapet.pet.data

import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.snapshots
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.Flow


class FirebasePetApi {
    private val db = Firebase.firestore

    fun getPets(): Flow<QuerySnapshot> {
        return db.collection("pets").snapshots()
    }

    fun getPetById(id: String): Flow<DocumentSnapshot> {
        return db.collection("pets").document(id).snapshots()
    }
}
