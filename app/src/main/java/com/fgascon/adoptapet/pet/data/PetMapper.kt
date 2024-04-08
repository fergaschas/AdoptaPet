package com.fgascon.adoptapet.pet.data

import com.fgascon.adoptapet.pet.domain.Pet
import com.google.firebase.firestore.DocumentSnapshot

fun DocumentSnapshot.toDomain(): Pet {
    return Pet(
        id = get("id").toString(),
        name = get("name").toString(),
        description = get("description").toString(),
        images = get("images") as List<String>,
        type = "dog",
        age = 5
    )
}
