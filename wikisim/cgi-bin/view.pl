#!"C:\xampp\perl\bin\perl.exe"
use strict;
use warnings;
use CGI;
use CGI::Carp qw(fatalsToBrowser);
use DBI;

my $cgi = CGI->new;
print $cgi->header;

my $id = $cgi->param('id');
my $dbh = DBI->connect("dbi:SQLite:dbname=db/BaseDeDatos.db", "admin", "admin");
my $sth = $dbh->prepare("SELECT title, content FROM Articles WHERE id = ?");
$sth->execute($id);

if (my @row = $sth->fetchrow_array) {
    my ($title, $content) = @row;
    print $cgi->start_html($title);
    print $cgi->h1($title);
    print $cgi->p($content);
    print $cgi->a({-href => '/cgi-bin/list.pl'}, 'Volver al Listado');
    print $cgi->end_html;
} else {
    print $cgi->start_html('Error');
    print $cgi->h1('Error');
    print $cgi->p('Página no encontrada.');
    print $cgi->a({-href => '/cgi-bin/list.pl'}, 'Volver al Listado');
    print $cgi->end_html;
}

$dbh->disconnect;
