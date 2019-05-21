import artm

batch_vectorizer = artm.BatchVectorizer(data_path="ready_data.txt",
                                        data_format="vowpal_wabbit",
                                        target_folder="vk_batches",
                                        batch_size=100)