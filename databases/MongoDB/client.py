from pymongo import MongoClient

client = MongoClient('mongodb://localhost:27017/')

db = client['app']

collection = db['foo']

document = dict(name='Jane Doe', age=30, email='janedoe@email.com')

result = collection.insert_one(document)

if result.acknowledged:
    print('Inserted Document ID: ', result.inserted_id)
else:
    print('Failed to insert document.')

query = dict(age={'$gte': 29})
documents = collection.find(query)
for document in documents:
    print(documents)
