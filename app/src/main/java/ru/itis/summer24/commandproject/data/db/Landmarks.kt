package ru.itis.summer24.commandproject.data.db

import ru.itis.summer24.commandproject.data.db.entities.LandmarkEntity

object Landmarks {
    val testLandmarks: List<LandmarkEntity> = listOf(
        LandmarkEntity(
            name = "Eiffel Tower",
            runame = "Эйфелева башня",
            imageUrl = "https://u-stena.ru/upload/iblock/352/3529f0013821edca1b6bcaebb602622b.jpg",
            city = "Paris",
            rucity = "Париж",
            shortInformation = "The Eiffel Tower is a wrought-iron lattice tower in Paris, France. It is named after Gustave Eiffel.",
            rushortInformation = "Эйфелева башня - это башня с кованой решеткой в Париже, Франция. Она названа в честь Гюстава Эйфеля.",
            longInformation = "The Eiffel Tower is a wrought-iron lattice tower on the Champ de Mars in Paris, France. It is named after the engineer Gustave Eiffel, whose company designed and built the tower. Constructed in 1887–1889 as the entrance arch to the 1889 World's Fair, it has become both a global cultural icon of France and one of the most recognizable structures in the world.",
            rulongInformation = "Эйфелева башня - это решетчатая башня из кованого железа на Марсовом поле в Париже, Франция. Она названа в честь инженера Гюстава Эйфеля, чья компания спроектировала и построила башню. Построенный в 1887-1889 годах как входная арка на Всемирную выставку 1889 года, он стал мировой культурной иконой Франции и одним из самых узнаваемых сооружений в мире.",
            visit = 0
        ),
        LandmarkEntity(
            name = "Taj Mahal",
            runame = "Тадж-Махал",
            imageUrl = "https://s1.1zoom.ru/big7/731/Temples_India_Taj_Mahal_469324.jpg",
            city = "Agra",
            rucity = "Агра",
            shortInformation = "The Taj Mahal is an ivory-white marble mausoleum in Agra, India.",
            rushortInformation = "Тадж-Махал - это мавзолей из белого мрамора цвета слоновой кости в Агре, Индия.",
            longInformation = "The Taj Mahal is an ivory-white marble mausoleum on the right bank of the Yamuna river in the Indian city of Agra. It was commissioned in 1632 by the Mughal emperor Shah Jahan to house the tomb of his favorite wife, Mumtaz Mahal. The Taj Mahal is considered to be the jewel of Islamic art in India and one of the most universally admired masterpieces in the world's heritage.",
            rulongInformation = "Тадж-Махал - это мавзолей из белого мрамора цвета слоновой кости, расположенный на правом берегу реки Ямуна в индийском городе Агра. Он был построен по заказу императора Великих Моголов Шаха Джахана в 1632 году для размещения гробницы его любимой жены Мумтаз Махал. Тадж-Махал считается жемчужиной исламского искусства в Индии и одним из самых почитаемых шедевров мирового наследия.",
            visit = 0
        ),
        LandmarkEntity(
            name = "Great Wall of China",
            runame = "Великая Китайская стена",
            imageUrl = "https://upload.wikimedia.org/wikipedia/commons/2/23/The_Great_Wall_of_China_at_Jinshanling-edit.jpg",
            city = "Beijing",
            rucity = "Пекин",
            shortInformation = "The Great Wall of China is a series of fortifications in Beijing, China.",
            rushortInformation = "Великая Китайская стена - это серия укреплений в Пекине, Китай.",
            longInformation = "The Great Wall of China is a series of fortifications made of stone, brick, tamped earth, wood, and other materials, generally built along an east-to-west line across the historical northern borders of China to protect the Chinese states and empires against the raids and invasions of the various nomadic groups.",
            rulongInformation = "Великая Китайская стена - это серия укреплений из камня, кирпича, утрамбованной земли, дерева и других материалов, обычно возводимых вдоль исторической северной границы Китая с востока на запад для защиты китайских государств и империй от набегов и вторжений различных кочевых групп.",
            visit = 0
        ),
        LandmarkEntity(
            name = "Machu Picchu",
            runame = "Мачу-Пикчу",
            imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/Machu_Picchu%2C_Peru.jpg/1200px-Machu_Picchu%2C_Peru.jpg",
            city = "Cusco",
            rucity = "Куско",
            shortInformation = "Machu Picchu is a 15th-century Inca citadel in Cusco, Peru.",
            rushortInformation = "Мачу-Пикчу - это цитадель инков 15 века в Куско, Перу.",
            longInformation = "Machu Picchu is a 15th-century Inca citadel located in the Eastern Cordillera of southern Peru on a 2,430-meter mountain ridge. It is located in the Machupicchu District in Urubamba Province within the Cusco Region. Machu Picchu is probably the most familiar symbol of the Inca Empire.",
            rulongInformation = "Мачу-Пикчу - это цитадель инков XV века, расположенная в Восточных Кордильерах на юге Перу на горном хребте высотой 2430 метров. Он расположен в округе Мачупиччу провинции Урубамба в регионе Куско. Мачу-Пикчу, пожалуй, самый известный символ империи инков.",
            visit = 0
        ),
        LandmarkEntity(
            name = "Pyramids of Giza",
            runame = "Пирамиды Гизы",
            imageUrl = "https://i.natgeofe.com/n/535f3cba-f8bb-4df2-b0c5-aaca16e9ff31/giza-plateau-pyramids.jpg",
            city = "Giza",
            rucity = "Гиза",
            shortInformation = "The Pyramids of Giza are ancient monuments in Giza, Egypt.",
            rushortInformation = "Пирамиды Гизы - это древние памятники в Гизе, Египет.",
            longInformation = "The Pyramids of Giza consist of the Great Pyramid of Giza (also known as the Pyramid of Cheops or Khufu), the Pyramid of Khafre, and the Pyramid of Menkaure, along with the Great Sphinx of Giza. These ancient structures are some of the most famous monuments of ancient Egyptian civilization.",
            rulongInformation = "Пирамиды Гизы состоят из Великой пирамиды Гизы (также известной как пирамида Хеопса или Хуфу), пирамиды Хефрена и пирамиды Менкаура, а также Большого Сфинкса в Гизе. Эти древние сооружения являются одними из самых известных памятников древнеегипетской цивилизации.",
            visit = 0
        )
    )
}