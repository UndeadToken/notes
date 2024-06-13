# Django

#### Setup

Install dependencies.

```bash
python -m venv venv
source ./venv/bin/activate
python -m pip install Django~=5.0.4
python -m django --version
```

Setup the project.

```bash
django-admin startproject mysite
python manage.py runserver
python manage.py runserver 127.0.0.1 --settings=mysite.settings
python manage.py startapp blog
```

Add the `blog.apps.BlogConfig` to INSTALLED_APPS in settings.py.

Access the shell.

```python
python manage.py shell
```

https://docs.djangoproject.com/en/5.0/intro/install

#### Admin

```python
python manage.py createsuperuser
```

https://docs.djangoproject.com/en/5.0/ref/contrib/admin

#### Model-Template-View (MTV)

Similar to MVC (Model-View-Controller). The template acts as the view and the framework 
itself as the controller. It sends a request to the appropriate view, according to the
Django URL configuration.

Model: 
This defines the logical data structure and is the data handler between the database and 
the view.

Template:
This is the presentation layer. Django uses a plain-text template system that keeps everything that
the browser renders.

View:
This communicates with the database via the model and transfers the data to the template for
viewing.

#### Request - Response

HTTP Request
Browser URL Dispatcher -> View -> Model -> Database 

HTTP Response
Database -> Model -> View -> TEMPLATE -> Browser

### Django 5 Features

- Facet filters in the administration site
- Simplified templates for the form field rendering
- Database-computed default values
- Database generated model fields
- More options for generating model field choices
- Improvements to ASGI (Asynchronous Server Gateway Interface) support. Asyncrhonous handlers, class-based views and asynchronous ORM in Django 3. Django 5 adds asynchronous functions to the authentication framework, provides support for asynchronous signal dispatching, and adds asynchronous support multiple built-in decorators.

### Project Upgrade

django-upgrade was inspired by pyupgrade. Pyupgrade automatically upgrades syntax for newer versions of python. 

https://github.com/adamchainz/django-upgrade

https://github.com/asottile/pyupgrade

### Settings

https://docs.djangoproject.com/en/5.0/ref/settings

### Databases

Specify the `db_name` attribute on the model to customize the table name. `primary_key=True` on a model field
to assign primary key. You can configure database routers to create custom data routing schemas. The Django ORM
is based on QuerySets.

Create migrations from models.
```bash
python manage.py makemigrations myapp
python manage.py migrate
```

The sqlmigrate command takes the migration names and returns SQL without executing it.

```bash
python manage.py sqlmigrate blog 0001
```

https://docs.djangoproject.com/en/5.0/topics/install/#database-installation


### Models

In MySQL index sorting is not supported, a descending index will be created as a normal index. Each
Django object has at least one manager and the default manager is called objects. You get a QuerySet
object using your model manager.

Creating Models.
```python
from blog.models import Post

user = User.objects.get(username='foo')

post = Post(title='Fizz', slug='fizz', body='...', author=user)

post.save()

Post.objects.create(title='Fizz', slug='fizz', body='...', author=user)
```

Fetching Models.
```python
user = User.objects.get(username='foo')

user, created = User.objects.get_or_create(username='foo')

Post.objects.get()
Post.objects.all()

posts = Post.objects.filter(title='foo')
print(posts.query)
```

Updating models.
```python
user.title = 'Foo'
user.save()
```

Filtering models.

The QuerySet interface provides you with multiple lookup types. Two underscores are used to define 
the lookup type. When no lookup type is provided, the lookup type is assumed to be exact.
```python
from datetime import date

Post.objects.filter(id__exact=1)
Post.objects.filter(id=1)
Post.objects.filter(id_in=[1,2])
Post.objects.filter(id_gt=3) # Greater than
Post.objects.filter(id_gte=3) # Greater than or equal
Post.objects.filter(id_lt=3) # Less than
Post.objects.filter(id_lte=3) # Less than or equal
Post.objects.filter(title_iexact='foo') # Case-insensitive lookup
Post.objects.filter(title_contains='foo') # LIKE
Post.objects.filter(title_icontains='foo') # LIKE case-insensitive
Post.objects.filter(title_istartswith='foo')
Post.objects.filter(title_iendswith='foo')
Post.objects.filter(publish__date=date(2024, 1, 31))
Post.objects.filter(publish__year=2024)
Post.objects.filter(publish__month=1)
Post.objects.filter(publish__day=1)
Post.objects.filter(publish__date__gt=date(2024, 1, 1))
Post.objects.filter(author__username='foo') # relation
Post.objects.filter(author__username__startswith='foo')
Post.objects.filter(id_in=[1,2]).filter(title_icontains='foo')
Post.objects.filter(publish_year=2024).exclude(title_icontains='foo')
```

Sorting objects.

```python
Post.objects.order_by('title')
Post.objects.order_by('-title')
Post.objects.order_by('author', 'title')
Post.objects.order_by('?') # Random order.
```

Limits.
```python
Post.objects.all()[:5] # SQL LIMIT 5 Clause
Post.objects.all()[3:6] # SQL OFFSET 3 LIMIT 5 Clause
Post.objects.order_by('?')[0] # First object in random order
```

Counting objects.
```python
Post.objects.filter(id_lt=3).count()
```

Check if object exists.
```python
Post.objects.filters(title_startswith='why').exists()
```

Delete Objects.
```python
post = Post.objects.get(id=1)
post.delete()
```

#### Complex Lookups with Q Objects.

Field lookups using filter() are joined using the AND operator.

A Q object allows you to encapsulate a collection of field lookups.

```python
from django.db.models import Q

starts_who = Q(title__istartswith='who')
starts_why = Q(title__istartswith='why')
Post.objects.filter(starts_who | starts_why)
```

https://docs.djangoproject.com/en/5.0/topics/db/queries/#complex-lookups-with-q-objects
https://docs.djangoproject.com/en/5.0/ref/models/querysets

https://docs.djangoproject.com/en/5.0/ref/models/fields/#django.db.models.Field.db_default
https://docs.djangoproject.com/en/5.0/ref/models/database-functions
https://docs.djangoproject.com/en/5.0/ref/models/indexes
https://docs.djangoproject.com/en/5.0/ref/models/fields

#### Status Field

In the example below the available choices for the post status are DRAFT and PUBLISHED. Their respective values
are DF and PB, and their labels or readable names are Draft and Published. `Post.Status.DRAFT`; `Post.Status.choices`, 
`Post.Status.names`, `Post.Status.labels`, `Post.Status.values`.

```python
from django.db import models


class Post(models.Model):
    class Status(models.TextChoices):
        DRAFT = 'DF', 'Draft'
        PUBLISHED = 'PB', 'Published'
        
    status = models.CharField(
        max_length=2,
        choices=Status,
        default=Status.DRAFT,
    )
```

#### Foreign Keys

```python
from django.conf import settings

author = models.ForeignKey(
    settings.AUTH_USER_MODEL,
    on_delete=models.CASCADE,
    related_name='blog_posts',
)
```

#### Managers

The first manager in the model becomes the default manager. If no manager is defined
in the model Django automatically creates the objects default manager. You can also
use the meta attribute `default_manager_name` to specify the default manager.

```python
class PublishedManager(models.Manager):
    def get_queryset(self):
        return (
            super().get_queryset().filter(status=Post.Status.PUBLISHED)
        )

class Post(models.Model):
    ...
    published = PublishedManager()
```

https://docs.djangoproject.com/en/5.0/ref/models/fields/#enumeration-types

#### Dates

auto_now_add: Date will be saved automatically when creating the object.
auto_now: Date will be saved when updating the model.

### Templates

`{% load static %}` tells Django to load the static template tags that are provided by the django.contrib.staticfiles 
application, which is contained in the INSTALLED_APPS section.

```
templates/
    blog/
        base.html
        post/
            list.html
            detail.html
```

```html
{% load static %}
<!DOCTYPE html>
<html>
<head>
    <title>{% block title %}{% endblock %}</title>
    <link href="{% static "css/blog.css" %}" rel=stylesheet>
</head>
</html>
```

https://docs.djangoproject.com/en/5.0/ref/templates/language
https://docs.djangoproject.com/en/5.0/ref/templates/builtins

### List & Detail Views

A Django view is just a python function that receives a web request and returns a web response.

https://docs.djangoproject.com/en/5.0/topics/http/urls/#path-converters
https://docs.djangoproject.com/en/5.0/topics/http/urls/#django.urls.re_path
https://docs.djangoproject.com/en/5.0/topics/http/urls/#url-namespaces
https://docs.djangoproject.com/en/5.0/ref/urlresolvers


### Production

Deploy as an WSGI application with Apache, Gunicorn, uWSGI or as an ASGI application using a server
such as Daphne or Uvicorn.

https://docs.djangoproject.com/en/5.0/topics/howto/deployment/wsgi

### Resources

https://github.com/PacktPublishing/Django-5-by-example/tree/main/Chapter01
