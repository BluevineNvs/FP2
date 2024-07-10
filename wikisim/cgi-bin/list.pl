#!"C:\xampp\perl\bin\perl.exe"
use strict;
use warnings;
use CGI;
use CGI::Carp qw(fatalsToBrowser);
use DBI;

my $cgi = CGI->new;
print $cgi->header;
print $cgi->start_html('Listado de Páginas');

my $dbh = DBI->connect("dbi:SQLite:dbname=db/BaseDeDatos.db", "admin", "admin");
my $sth = $dbh->prepare("SELECT id, title FROM Articles");
$sth->execute();

print $cgi->h1('Listado de Páginas');
print $cgi->start_ul;

while (my @row = $sth->fetchrow_array) {
    my ($id, $title) = @row;
    print $cgi->li(
        $cgi->a({-href => "/cgi-bin/view.pl?id=$id"}, $title) . " " .
        $cgi->a({-href => "/cgi-bin/edit.pl?id=$id"}, '(E)') . " " .
        $cgi->a({-href => "/cgi-bin/delete.pl?id=$id"}, '(X)')
    );
}

print $cgi->end_ul;
print $cgi->a({-href => '/cgi-bin/new.pl'}, 'Agregar Nueva Página');
print $cgi->end_html;

$dbh->disconnect;
