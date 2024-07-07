package ru.itis.summer24.commandproject.data.db

import ru.itis.summer24.commandproject.models.Landmark

object Landmarks {
    val testLandmarks: List<Landmark> = listOf(
        Landmark(
            id = 0,
            name = "Eiffel Tower",
            imageUrl = "https://upload.wikimedia.org/wikipedia/commons/a/a8/Eiffel_Tower_Paris.jpg",
            city = "Paris",
            shortInformation = "The Eiffel Tower is a wrought-iron lattice tower in Paris, France. It is named after Gustave Eiffel.",
            longInformation = "The Eiffel Tower is a wrought-iron lattice tower on the Champ de Mars in Paris, France. It is named after the engineer Gustave Eiffel, whose company designed and built the tower. Constructed in 1887–1889 as the entrance arch to the 1889 World's Fair, it has become both a global cultural icon of France and one of the most recognizable structures in the world.",
            visit = 0
        ),
        Landmark(
            id = 1,
            name = "Taj Mahal",
            imageUrl = "https://upload.wikimedia.org/wikipedia/commons/1/1c/Taj_Mahal_in_India_-_Kristian_Bertel.jpg",
            city = "Agra",
            shortInformation = "The Taj Mahal is an ivory-white marble mausoleum in Agra, India.",
            longInformation = "The Taj Mahal is an ivory-white marble mausoleum on the right bank of the Yamuna river in the Indian city of Agra. It was commissioned in 1632 by the Mughal emperor Shah Jahan to house the tomb of his favorite wife, Mumtaz Mahal. The Taj Mahal is considered to be the jewel of Islamic art in India and one of the most universally admired masterpieces in the world's heritage.",
            visit = 0
        ),
        Landmark(
            id = 2,
            name = "Great Wall of China",
            imageUrl = "https://upload.wikimedia.org/wikipedia/commons/2/23/The_Great_Wall_of_China_at_Jinshanling-edit.jpg",
            city = "Beijing",
            shortInformation = "The Great Wall of China is a series of fortifications in Beijing, China.",
            longInformation = "The Great Wall of China is a series of fortifications made of stone, brick, tamped earth, wood, and other materials, generally built along an east-to-west line across the historical northern borders of China to protect the Chinese states and empires against the raids and invasions of the various nomadic groups.",
            visit = 0
        ),
        Landmark(
            id = 3,
            name = "Machu Picchu",
            imageUrl = "https://upload.wikimedia.org/wikipedia/commons/1/14/80_-_Peru_-_Machu_Picchu_-_Juin_2009_-_edit.2.jpg",
            city = "Cusco",
            shortInformation = "Machu Picchu is a 15th-century Inca citadel in Cusco, Peru.",
            longInformation = "Machu Picchu is a 15th-century Inca citadel located in the Eastern Cordillera of southern Peru on a 2,430-meter mountain ridge. It is located in the Machupicchu District in Urubamba Province within the Cusco Region. Machu Picchu is probably the most familiar symbol of the Inca Empire.",
            visit = 0
        ),
        Landmark(
            id = 4,
            name = "Pyramids of Giza",
            imageUrl = "https://upload.wikimedia.org/wikipedia/commons/6/63/Gizeh%2C_Pyramids%2C_Egypt%2C_1904-1905%2C_Temple%2C_Antiquit%C3%A4t%2C_Altes_%C3%84gypten%2C_Travel%2C_Kunstverlag_Ernst_Wasmuth%2C_Berlin-Dahlem%2C_2013.JPG",
            city = "Giza",
            shortInformation = "The Pyramids of Giza are ancient monuments in Giza, Egypt.",
            longInformation = "The Pyramids of Giza consist of the Great Pyramid of Giza (also known as the Pyramid of Cheops or Khufu), the Pyramid of Khafre, and the Pyramid of Menkaure, along with the Great Sphinx of Giza. These ancient structures are some of the most famous monuments of ancient Egyptian civilization.",
            visit = 0
        )
    )
}