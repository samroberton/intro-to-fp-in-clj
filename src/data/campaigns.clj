(ns data.campaigns)


(def campaigns
  [{:account/id          1234
    :account/name        "Sports sports sports"
    :campaign/id         123456789
    :campaign/name       "I love sports!"
    :campaign/targetting {:targetting/eventid #{"AUSvNZL"}}
    :campaign/creatives  [{:creative/id         99999999
                           :creative/text       "Wanna come see sports, bro?"
                           :creative/targetting {:targetting/gender #{"M"}
                                                 :targetting/age    #{"18-24" "24-30"}}}
                          {:creative/id   88888888
                           :creative/text "Do you enjoy sporting activity?"}]}
   {:account/id          1234
    :account/name        "Sports sports sports"
    :campaign/id         123456789
    :campaign/name       "I love sports!"
    :campaign/targetting {:targetting/eventid #{"AUSvNZL"}}
    :campaign/creatives  [{:creative/id         99999999
                           :creative/text       "Wanna come see sports, bro?"
                           :creative/targetting {:targetting/gender #{"M"}
                                                 :targetting/age    #{"18-24" "24-30"}}}
                          {:creative/id   88888888
                           :creative/text "Do you enjoy sporting activity?"}]}
   {:account/id         1234
    :account/name       "Sports sports sports"
    :campaign/id        123456789
    :campaign/name      "Open"
    :campaign/creatives [{:creative/id   88888888
                          :creative/text "Do you enjoy sporting activity?"}]}
   {:account/id          1234
    :account/name        "Sports sports sports"
    :campaign/id         123454321
    :campaign/name       "This is not best one"
    :campaign/targetting {:targetting/age #{"18-24"}}
    :campaign/creatives  [{:creative/id         77777777
                           :creative/text       "Ping-pong?"
                           :creative/targetting {:targetting/gender #{"F"}}}]}
   {:account/id         5678
    :account/name       "Travel-tastic"
    :campaign/id        567891234
    :campaign/name      "Let's get travelling"
    :campaign/creatives [{:creative/id   66666666
                          :creative/text "Who doesn't like travelling?!"}]}
   {:account/id         1289
    :account/name       "Hotels"
    :campaign/id        128934675
    :campaign/name      "Fancy hotels"
    :campaign/creatives [{:creative/id         55555555
                          :creative/text       "Look at all the cushions on this bed!"
                          :creative/targetting {:targetting/gender #{"F"}}}]}])
