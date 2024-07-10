package ru.itis.summer24.commandproject.data.db

import ru.itis.summer24.commandproject.data.db.entities.NewsEntity

object News {
    val testNews: List<NewsEntity> = listOf(
        NewsEntity(
            id = 0,
            name = "Plans for the development of the application",
            runame = "Планы по развитию приложения",
            description = "We are not standing still and are already planning new features for the application. In the near future we will add a built-in social network for those who like to travel and much more!  Stay tuned!",
            rudescription = "Мы не стоим на месте и уже планируем новые возможности для приложения. В ближайшее время мы добавим встренную соцсеть для тех, кто любит путешествовать  и многое другое!  Следите за обновлениями!",
            date = "10.07.2024",
            url = "https://static.bntu.by/bntu/new/news/image_12474_13efacb7d19a9c3019374a47aff84757.jpg%7CresizeToWidth=1400"
        ),
        NewsEntity(
            id = 1,
            name = "The application has started its work!",
            runame = "Приложение начало свою работу!",
            description = "We are pleased to announce that our app has officially launched!  Now you have a guide to the world's attractions right in your smartphone. We hope that using it will give you incredible emotions!",
            rudescription = "Мы рады сообщить, что наше приложение официально запущено!  Теперь у вас есть путеводитель по мировым достопримечательностям прямо в вашем смартфоне. Надееемся, что его использование подарит вам невереоятные эмоции!",
            date = "09.07.2024",
            url = "https://topotkritki.ru/wp-content/uploads/2023/11/smailik-s-dnem-rozhdeniia-18.webp"
        ),
        NewsEntity(
            id = 2,
            name = "Happy Cucumber Day!",
            runame = "С Днём Огурца!",
            description = "Happy Cucumber Day!  May this wonderful vegetable always be fresh, crispy and delicious!  We wish you to enjoy its taste and benefits!",
            rudescription = "С Днём Огурца!  Пусть этот замечательный овощ всегда будет свежим, хрустящим и вкусным!  Желаем вам наслаждаться его вкусом и пользой!",
            date = "08.07.2024",
            url = "https://avatars.dzeninfra.ru/get-zen_doc/1907561/pub_6503530f4d91f006084b6f1b_6503594043ff0d44cd671d26/scale_1200"
        ),
        NewsEntity(
            id = 3,
            name = "Happy Peter and Fevronia Day!",
            runame = "С Днём Петра и Февронии!",
            description = "Happy Family Day, love and fidelity! Let this day remind us of the importance of strong family ties, mutual love and loyalty. We wish you all happiness, harmony and well-being!",
            rudescription = "С Днем семьи, любви и верности! Пусть этот день напоминает нам о важности крепких семейных уз, взаимной любви и верности. Желаем всем  счастья, гармонии и благополучия!",
            date = "08.07.2024",
            url = "https://gas-kvas.com/uploads/posts/2023-01/1674133464_gas-kvas-com-p-risunok-den-petra-i-fevronii-1.jpg"
        ),
        NewsEntity(
            id = 4,
            name = "A day of lying on the couch!",
            runame = "День лежания на диване!",
            description = "Happy Couch-sitting Day!  Put everything aside, get comfortable, grab your favorite book or movie and enjoy a well-deserved rest.  May this day be full of relaxation and pleasant moments!",
            rudescription = "С Днем лежания на диване!  Отложите все дела, устройтесь поудобнее, возьмите любимую книгу или фильм и наслаждайтесь заслуженным отдыхом.  Пусть этот день будет  полным  расслабления и приятных  моментов!",
            date = "19.06.2024",
            url = "https://cs12.pikabu.ru/post_img/2022/05/28/9/1653747692186637870.jpg"
        ),
        NewsEntity(
            id = 5,
            name = "Happy Russia Day!",
            runame = "С Днём России!",
            description = "Happy Russia Day!  We wish you all good health, happiness, prosperity and a peaceful sky above your head!  May our country always be strong, beautiful and rich!",
            rudescription = " С Днём России!  Желаем всем крепкого здоровья, счастья, процветания и мирного неба над головой!  Пусть наша страна всегда будет сильной, красивой и богатой!",
            date = "12.06.2024",
            url = "https://cs12.pikabu.ru/post_img/2022/05/28/9/1653747692186637870.jpg"
        ),
        NewsEntity(
            id = 6,
            name = "Happy Cat Day!",
            runame = "С Днем кота!",
            description = "Happy Cat Day!  Let your furry friends delight you with their purring, playfulness and warmth.  We wish them health, happiness and lots of affection!",
            rudescription = "С Днем кота!  Пусть ваши пушистые друзья  радуют вас своим мурчанием, игривостью и  теплотой.  Желаем им  здоровья,  счастья  и  много  ласки!",
            date = "01.05.2024",
            url = "https://cvam.ru/wp-content/uploads/2023/12/den-koshek-20.webp"
        ),
        NewsEntity(
            id = 7,
            name = "Happy Osal Day!",
            runame = "С Днем Осал!",
            description = "Happy Osal Day! May this holiday bring joy, success and good mood to every donkey!  We wish them health, happiness and well-being!",
            rudescription = "С Днем Осал! Пусть этот праздник  принесет  каждому ослу радость,  успех  и  хорошее  настроение!  Желаем им  здоровья,  счастья  и  благополучия!",
            date = "30.02.2024",
            url = "https://avatars.dzeninfra.ru/get-zen_doc/5231727/pub_63c1684eb91c2c52dae7e092_63c168607ea81f2cee27280a/scale_1200"
        ),
        NewsEntity(
            id = 8,
            name = "Some kind of holiday",
            runame = "Какой-то праздник",
            description = "This is some kind of holiday that no one will watch. Why did I write all this at all?",
            rudescription = "Это ещё какой-то праздник, который никто не будет смотреть. Зачем я вообще всё этописал ?",
            date = "Ufa",
            url = "https://cs12.pikabu.ru/post_img/2022/05/28/9/1653747692186637870.jpg"
        ),
    )
}