package com.fgascon.adoptapet.pet.data

import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.snapshots
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class FirebasePetApi @Inject constructor (
    private val db :FirebaseFirestore
){

    fun getPets(): Flow<QuerySnapshot> {
        return db.collection("pets").snapshots()
    }

    fun getPetById(id: String): Flow<DocumentSnapshot> {
        return db.collection("pets").document(id).snapshots()
    }
}
