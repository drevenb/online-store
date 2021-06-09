create table admin
(
    id       uuid not null,
    name     varchar(255),
    password varchar(255),
    primary key (id)
);

create table customer
(
    id      uuid         not null,
    address varchar(255) not null,
    email   varchar(255) not null,
    name    varchar(255) not null,
    phone   varchar(255) not null,
    primary key (id)
);

create table motherboard
(
    id                   uuid         not null,
    name                 varchar(255) not null,
    form_factor          varchar(255) not null,
    memory_slots         integer,
    memory_type          varchar(255) not null,
    producer             varchar(255) not null,
    price                double precision,
    remainder            integer,
    socket               varchar(255) not null,
    primary key (id)
);

create table ordering
(
    id            uuid not null,
    delivery_date timestamp,
    status        varchar(255),
    total_sum     double precision,
    customer_id   uuid not null,
    primary key (id)
);

create table ordering_product
(
    product_id  uuid not null,
    ordering_id uuid not null
);

create table processor
(
    id                 uuid         not null,
    name               varchar(255) not null,
    cores_quantity     integer,
    frequency          integer,
    price              double precision,
    producer           varchar(255) not null,
    remainder          integer,
    socket             varchar(255) not null,
    primary key (id)
);

create table product
(
    id             uuid not null,
    motherboard_id uuid,
    processor_id   uuid,
    ram_id         uuid,
    videocard_id   uuid,
    primary key (id)
);

create table ram
(
    id               uuid         not null,
    name             varchar(255) not null,
    latency          varchar(255) not null,
    memory_frequency integer      not null,
    memory_size      integer      not null,
    memory_type      varchar(255) not null,
    price            double precision,
    producer         varchar(255) not null,
    remainder        integer,
    primary key (id)
);

create table videocard
(
    id                  uuid         not null,
    name                varchar(255) not null,
    memory_buswidth     integer      not null,
    memory_frequency    integer      not null,
    memory_size         integer      not null,
    memory_type         varchar(255) not null,
    price               double precision,
    processor_frequency integer      not null,
    producer            varchar(255) not null,
    remainder           integer,
    primary key (id)
);

alter table ordering
    add constraint FKjod0wwyxabi7qyx9fmlntsxq4 foreign key (customer_id) references customer;

alter table ordering_product
    add constraint FKjod0wwyxabi7qyx9fmg5aerha foreign key (ordering_id) references ordering;

alter table ordering_product
    add constraint FKjod0wwyxahaerhaer4lntsxq4 foreign key (product_id) references product;

alter table product
    add constraint FKjod0wwy0r9ghwoefowiehf39w foreign key (motherboard_id) references motherboard;

alter table product
    add constraint FKjod0wwyxahaerhaer45qhq45h foreign key (processor_id) references processor;

alter table product
    add constraint FKjod0wwyxahaerhaeraeg42uhy foreign key (ram_id) references ram;

alter table product
    add constraint FKjod0wwyxahaeaerg25tdwkjk4 foreign key (videocard_id) references videocard;